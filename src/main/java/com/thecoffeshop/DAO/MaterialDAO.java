package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.MaterialDAOImp;
import com.thecoffeshop.entity.Material;
import com.thecoffeshop.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MaterialDAO implements MaterialDAOImp {
	@Autowired
	MaterialRepository materialRepository;

	@Override
	public Boolean addMaterial(Material material) {
		Boolean aBoolean;
		try{
			materialRepository.save(material);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public List<Material> findAll() {
		return materialRepository.findAllByIsdelete(this.IS_NOT_DELETE);
	}

	@Override
	public List<Material> findLimit(int start) {
		return materialRepository.findAllLimit(this.IS_NOT_DELETE, start*this.MAX_RESULTS, this.MAX_RESULTS);
	}

	@Override
	public Material getInfoById(int materialid) {
		return materialRepository.findById(materialid).get();
	}

	@Override
	public Boolean checkExistNameMaterial(String name) {
		Boolean aBoolean;
		try{
			Material material = materialRepository.findByIsdeleteAndName(this.IS_NOT_DELETE, name);
			if (material !=null){
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
	public Boolean deleteAtposition(int materialid) {
		Boolean aBoolean;
		try{
			materialRepository.deleteById(materialid);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Boolean editMaterial(Material material) {
		Boolean aBoolean;
		try{
			materialRepository.save(material);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}
}