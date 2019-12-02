package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.ImportBillDAOImp;
import com.thecoffeshop.entity.Importbill;
import com.thecoffeshop.entity.Importbilldetail;
import com.thecoffeshop.repository.ImportbillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ImportBillDAO implements ImportBillDAOImp {
	@Autowired
	ImportbillRepository importbillRepository;

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
	public int tongtienImportBill(Date date) {
		try {
			List<Importbill> importbills = importbillRepository.findAllByIsdeleteAndUpdateat(this.IS_NOT_DELETE, date);
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
		}
	}

	@Override
	public int soluongImportBill(Date date) {
		int count;
		try {
			List<Importbill> importbills = importbillRepository.findAllByIsdeleteAndUpdateat(this.IS_NOT_DELETE, date);
			count = importbills.size();
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			count = 0;
		}
		return count;
	}

	@Override
	public int tongtienImportBillTrongTuan(int tuan) {
		return 0;
	}

	@Override
	public int soluongImportBillTrongTuan(int tuan) {
		return 0;
	}

	@Override
	public int tongtienImportBillTrongThang(int thang) {
		return 0;
	}

	@Override
	public int soluongImportBillTrongThang(int thang) {
		return 0;
	}
}
