package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.ExportbilldetailDAOImp;
import com.thecoffeshop.entity.Exportbilldetail;
import com.thecoffeshop.entity.ExportbilldetailId;
import com.thecoffeshop.repository.ExportbilldetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ExportbilldetailDAO implements ExportbilldetailDAOImp {
	@Autowired
	ExportbilldetailRepository exportbilldetailRepository;

	@Override
	public Boolean addExportbilldetail(Exportbilldetail exportbilldetail) {
		Boolean aBoolean;
		try{
			exportbilldetailRepository.save(exportbilldetail);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public List<Exportbilldetail> getInfoByExportbillId(int exportbillId) {
		return exportbilldetailRepository.getInfoByExportbillId(exportbillId, this.IS_NOT_DELETE);
	}

	@Override
	public Exportbilldetail getInfoByExportbilldetail(ExportbilldetailId id) {
		return exportbilldetailRepository.findById(id).get();
	}

	@Override
	public Boolean deleteExportbilldetail(Exportbilldetail exportbilldetail) {
		Boolean aBoolean;
		try{
			exportbilldetailRepository.delete(exportbilldetail);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Boolean editExportbilldetail(Exportbilldetail exportbilldetail) {
		Boolean aBoolean;
		try{
			exportbilldetailRepository.save(exportbilldetail);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public int getNumberExportbilldetail(int exportbillId) {
		List<Exportbilldetail> exportbilldetails;
		int numberExportbilldetail;
		try {
			exportbilldetails = getInfoByExportbillId(exportbillId);
			if (exportbilldetails.size()> 0){
				numberExportbilldetail = exportbilldetails.size();
			}else {
				numberExportbilldetail = 0;
			}
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			numberExportbilldetail = 0;
		}
		return numberExportbilldetail;
	}

	@Override
	public Boolean checkExistMaterialDetail(int materialdetailid) {
		Boolean aBoolean;
		Exportbilldetail exportbilldetail;
		try{
			exportbilldetail = exportbilldetailRepository.checkExistMaterialDetail(materialdetailid, this.IS_NOT_DELETE);
			if (exportbilldetail != null){
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
}
