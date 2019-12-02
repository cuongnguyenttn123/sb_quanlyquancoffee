package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.SupplierDAOImp;
import com.thecoffeshop.entity.Supplier;
import com.thecoffeshop.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SupplierDAO implements SupplierDAOImp {
	@Autowired
	SupplierRepository supplierRepository;

	@Override
	@Transactional
	public Boolean addSupplier(Supplier supplier) {
		Boolean aBoolean;
		try{
			supplierRepository.save(supplier);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public List<Supplier> findAll() {
		return supplierRepository.findAllByIsdelete(this.IS_NOT_DELETE);
	}

	@Override
	public List<Supplier> findLimit(int start) {
		return supplierRepository.findAllLimit(this.IS_NOT_DELETE, start*this.MAX_RESULTS, this.MAX_RESULTS);
	}

	@Override
	public Supplier getInfoById(int supplierid) {
		return supplierRepository.findById(supplierid).get();
	}

	@Override
	@Transactional
	public Boolean checkExistByName(String name) {
		Boolean aBoolean;
		Supplier supplier;
		try{
			supplier = supplierRepository.findByNameAndIsdelete(name, this.IS_NOT_DELETE);
			if (supplier != null){
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
	@Transactional
	public Boolean deleteSupplier(int supplierid) {
		Boolean aBoolean;
		try{
			supplierRepository.deleteById(supplierid);
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
	public Boolean editSupplier(Supplier supplier) {
		Boolean aBoolean;
		try{
			supplierRepository.save(supplier);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}
}