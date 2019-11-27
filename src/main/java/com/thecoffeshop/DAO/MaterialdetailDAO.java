package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.MaterialdetailDAOImp;
import com.thecoffeshop.entity.Bill;
import com.thecoffeshop.entity.Materialdetail;
import com.thecoffeshop.repository.MaterialdetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MaterialdetailDAO implements MaterialdetailDAOImp {
	@Autowired
	MaterialdetailRepository materialdetailRepository;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Override
	public int addMaterialdetail(Materialdetail materialdetail) {
		int lastId;
		try{
			materialdetailRepository.save(materialdetail);
			lastId = materialdetail.getMaterialdetailid();
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			lastId = -1;
		}
		return lastId;
	}

	@Override
	public List<Materialdetail> findAll() {
		return materialdetailRepository.findAllByIsdelete(this.IS_NOT_DELETE);
	}

	@Override
	public List<Materialdetail> search(String materialdetailid, String name) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			String hql = "FROM Materialdetail m WHERE m.quantity > 0 AND m.isdelete =:isdelete";
			if (!materialdetailid.isEmpty()) {
				hql = hql + " AND m.materialdetailid =:materialdetailid ";
			}
			if (!name.isEmpty()) {
				hql = hql + " AND m.material.name =:name ";
			}

			Query query = entityManager.createQuery(hql, Materialdetail.class);
			query.setParameter("isdelete", this.IS_NOT_DELETE);
			if (!materialdetailid.isEmpty()) {
				query.setParameter("materialdetailid", Integer.valueOf(materialdetailid));
			}
			if (!name.isEmpty()) {
				query.setParameter("name", name);
			}
			List<Materialdetail> materialdetails = query.getResultList();
			return materialdetails;

		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Materialdetail getInfoById(int materialdetailid) {
		return materialdetailRepository.findByIsdeleteAndMaterialdetailid(this.IS_NOT_DELETE, materialdetailid);
	}

	@Override
	public Boolean deleteMaterialdetail(int materialdetailid) {
		Boolean aBoolean;
		try{
			materialdetailRepository.deleteById(materialdetailid);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Boolean editMaterialdetail(Materialdetail materialdetail) {
		Boolean aBoolean;
		try{
			materialdetailRepository.save(materialdetail);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Boolean checkExistMaterial(int materialid) {
		Boolean aBoolean;
		List<Materialdetail> materialdetails;
		try{
			materialdetails = materialdetailRepository.checkExistMaterial(this.IS_NOT_DELETE, materialid);
			if (materialdetails.size() > 0){
				aBoolean = true;
			}else {
				aBoolean = false;
			}

		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public List<Materialdetail> layNguyenLieuTonKho(int materialid) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {

			List<Materialdetail> materialdetails = entityManager.createQuery(
					"FROM Materialdetail m WHERE m.quantity > 0 AND m.material.materialid =:materialid AND m.isdelete =:isdelete ORDER BY m.materialdetailid ASC",
					Materialdetail.class).setParameter("materialid", materialid)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			return materialdetails;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int laySoNguyenLieuTonKho(int materialid) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {

			List<Materialdetail> materialdetails = entityManager.createQuery(
					"FROM Materialdetail m WHERE m.quantity > 0 AND m.material.materialid =:materialid AND m.isdelete =:isdelete ORDER BY m.materialdetailid ASC",
					Materialdetail.class).setParameter("materialid", materialid)
					.setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			if (materialdetails.size() <= 0) {
				return 0;
			}
			int total = 0;
			for (Materialdetail materialdetail : materialdetails) {
				total += materialdetail.getQuantity();
			}
			return total;
		} catch (Exception e) {

			return 0;
		}
	}
}