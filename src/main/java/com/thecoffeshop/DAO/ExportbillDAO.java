package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.ExportbillDAOImp;
import com.thecoffeshop.entity.Exportbill;
import com.thecoffeshop.repository.ExportbillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ExportbillDAO implements ExportbillDAOImp {
	@Autowired
	ExportbillRepository exportbillRepository;

	@Override
	@Transactional
	public int addExportbill(Exportbill exportbill) {
		int lastId;
		try{
			exportbillRepository.save(exportbill);
			lastId = exportbill.getExportbillid();
		}catch (Exception e){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			lastId = -1;
		}
		return lastId;
	}

	@Override
	public List<Exportbill> findAll() {
		return exportbillRepository.findAllByIsdelete(this.IS_NOT_DELETE);
	}

	@Override
	public List<Exportbill> findLimit(int start) {
		return exportbillRepository.findAllByLimit(this.IS_NOT_DELETE, start*this.MAX_RESULTS, this.MAX_RESULTS);
	}

	@Override
	public Exportbill getInfoById(int exportbillid) {
		return exportbillRepository.findById(exportbillid).get();
	}

	@Override
	public Boolean deleteExportbill(int exportbillid) {
		Boolean aBoolean;
		try{
			exportbillRepository.deleteById(exportbillid);
			aBoolean = true;
		}catch (Exception e){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Boolean editExportbill(Exportbill exportbill) {
		Boolean aBoolean;
		try{
			exportbillRepository.save(exportbill);
			aBoolean = true;
		}catch (Exception e){
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public int totalQuantityProduct(String productid) {
		List<Exportbill> exportbills;
		Integer total = 0;
		try {
			exportbills = exportbillRepository.totalQuantityProduct(productid, 0, this.IS_NOT_DELETE);
			if (exportbills.size()>0){
				for (Exportbill exportbill : exportbills) {
					total += exportbill.getQuantity();
				}
			}
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			total = 0;
		}
		return total;
	}

	@Override
	public List<Exportbill> getListExportBillbyProduct(String productid) {
		return exportbillRepository.getListExportBillbyProduct(productid, 0, this.IS_NOT_DELETE);
	}
}