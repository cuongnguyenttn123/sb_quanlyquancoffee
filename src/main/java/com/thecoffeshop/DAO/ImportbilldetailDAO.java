package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.ImportbilldetailDAOImp;
import com.thecoffeshop.entity.Importbilldetail;
import com.thecoffeshop.entity.ImportbilldetailId;
import com.thecoffeshop.repository.ImportbillRepository;
import com.thecoffeshop.repository.ImportbilldetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ImportbilldetailDAO implements ImportbilldetailDAOImp {
	@Autowired
	ImportbilldetailRepository importbilldetailRepository;

	@Override
	public Boolean addImportbilldetail(Importbilldetail importbilldetail) {
		Boolean aBoolean;
		try{
			importbilldetailRepository.save(importbilldetail);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public List<Importbilldetail> getInfoByImportbillid(int importbillid) {
		return null;
	}

	@Override
	public Importbilldetail getInfoByImportbilldetailId(ImportbilldetailId id) {
		return null;
	}

	@Override
	public Boolean deleteImportbilldetail(Importbilldetail importbilldetail) {
		Boolean aBoolean;
		try{
			importbilldetailRepository.delete(importbilldetail);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Boolean editImportbilldetail(Importbilldetail importbilldetail) {
		Boolean aBoolean;
		try{
			importbilldetailRepository.save(importbilldetail);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public int getNumberImportbilldetail(int importbillid) {
		return 0;
	}

	@Override
	public Boolean checkExistMaterialDetail(int materialdetailid) {
		Boolean aBoolean;
		try{

			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}
}
