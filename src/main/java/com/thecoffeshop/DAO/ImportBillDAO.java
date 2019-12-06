package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.ImportBillDAOImp;
import com.thecoffeshop.entity.Importbill;
import com.thecoffeshop.entity.Importbilldetail;
import com.thecoffeshop.repository.ImportbillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ImportBillDAO implements ImportBillDAOImp {
	@Autowired
	ImportbillRepository importbillRepository;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Override
	public int addImportBill(Importbill importbill) {
		int lastId;
		try{
			importbillRepository.save(importbill);
			lastId = importbill.getImportbillid();
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			lastId = -1;
		}
		return lastId;
	}

	@Override
	public List<Importbill> findAll() {
		return importbillRepository.findAllByIsdelete(this.IS_NOT_DELETE);
	}

	@Override
	public List<Importbill> findLimit(int start) {
		return importbillRepository.findAllLimit(this.IS_NOT_DELETE, start*this.MAX_RESULTS, this.MAX_RESULTS);
	}

	@Override
	public Importbill getInfoById(int importbillid) {
		return importbillRepository.findById(importbillid).get();
	}

	@Override
	public Boolean deleteImportBill(int importbillid) {
		Boolean aBoolean;
		try{
			importbillRepository.deleteById(importbillid);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Boolean editImportBill(Importbill importbill) {
		Boolean aBoolean;
		try{
			importbillRepository.save(importbill);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
    @Transactional
	public int tongtienImportBill(Date date) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			List<Importbill> importbills = entityManager
					.createQuery("FROM Importbill i WHERE  DATE(i.updateat) = DATE(:date) AND i.isdelete =:isdelete",
							Importbill.class)
					.setParameter("date", date).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			int total = 0;
			for (Importbill importbill : importbills) {
				Set<Importbilldetail> importbilldetails = importbill.getImportbilldetails();
				for (Importbilldetail importbilldetail : importbilldetails) {
					total += importbilldetail.getMaterialdetail().getQuantity()
							* importbilldetail.getMaterialdetail().getPrice();
				}
			}
			return total;
		} catch (Exception e) {

			return 0;
		} finally {
		    entityManager.close();
        }
	}

	@Override
    @Transactional
	public int soluongImportBill(Date date) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			List<Importbill> importbills = entityManager
					.createQuery("FROM Importbill i WHERE  DATE(i.updateat) = DATE(:date) AND i.isdelete =:isdelete",
							Importbill.class)
					.setParameter("date", date).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();

			return importbills.size();
		} catch (Exception e) {

			return 0;
		} finally {
		    entityManager.close();
        }
	}
	@Override
    @Transactional
	public int tongtienImportBillTrongTuan(int tuan) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			List<Importbill> importbills = entityManager
					.createQuery("FROM Importbill i WHERE WEEK(i.updateat) =:tuan AND i.isdelete =:isdelete",
							Importbill.class)
					.setParameter("tuan", tuan).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			int total = 0;
			for (Importbill importbill : importbills) {
				Set<Importbilldetail> importbilldetails = importbill.getImportbilldetails();
				for (Importbilldetail importbilldetail : importbilldetails) {
					total += importbilldetail.getMaterialdetail().getQuantity()
							* importbilldetail.getMaterialdetail().getPrice();
				}
			}
			return total;
		} catch (Exception e) {

			return 0;
		} finally {
		    entityManager.close();
        }
	}

	@Override
    @Transactional
	public int soluongImportBillTrongTuan(int tuan) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			List<Importbill> importbills = entityManager
					.createQuery("FROM Importbill i WHERE WEEK(i.updateat) =:tuan AND i.isdelete =:isdelete",
							Importbill.class)
					.setParameter("tuan", tuan).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();

			return importbills.size();
		} catch (Exception e) {

			return 0;
		} finally {
		    entityManager.close();
        }
	}

	@Override
    @Transactional
	public int tongtienImportBillTrongThang(int thang) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			List<Importbill> importbills = entityManager
					.createQuery("FROM Importbill i WHERE MONTH(i.updateat) =:thang AND i.isdelete =:isdelete",
							Importbill.class)
					.setParameter("thang", thang).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();
			int total = 0;
			for (Importbill importbill : importbills) {
				Set<Importbilldetail> importbilldetails = importbill.getImportbilldetails();
				for (Importbilldetail importbilldetail : importbilldetails) {
					total += importbilldetail.getMaterialdetail().getQuantity()
							* importbilldetail.getMaterialdetail().getPrice();
				}
			}
			return total;
		} catch (Exception e) {

			return 0;
		} finally {
            entityManager.close();
        }
	}

	@Override
    @Transactional
	public int soluongImportBillTrongThang(int thang) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			List<Importbill> importbills = entityManager
					.createQuery("FROM Importbill i WHERE MONTH(i.updateat) =:thang AND i.isdelete =:isdelete",
							Importbill.class)
					.setParameter("thang", thang).setParameter("isdelete", this.IS_NOT_DELETE).getResultList();

			return importbills.size();
		} catch (Exception e) {

			return 0;
		}finally {
            entityManager.close();
        }
	}

}
