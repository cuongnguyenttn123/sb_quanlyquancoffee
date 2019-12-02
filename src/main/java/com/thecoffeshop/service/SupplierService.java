package com.thecoffeshop.service;

import java.util.List;

import com.thecoffeshop.DAOImpl.SupplierDAOImp;
import com.thecoffeshop.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thecoffeshop.DAO.*;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class SupplierService implements SupplierDAOImp {

	@Autowired
	SupplierDAO supplierDAO;

	@Override
	public Boolean addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDAO.addSupplier(supplier);
	}

	@Override
	public List<Supplier> findAll() {
		// TODO Auto-generated method stub
		return supplierDAO.findAll();
	}

	@Override
	public Supplier getInfoById(int supplierid) {
		// TODO Auto-generated method stub
		return supplierDAO.getInfoById(supplierid);
	}

	@Override
	public Boolean deleteSupplier(int supplierid) {
		// TODO Auto-generated method stub
		return supplierDAO.deleteSupplier(supplierid);
	}

	@Override
	public Boolean editSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierDAO.editSupplier(supplier);
	}

	@Override
	public List<Supplier> findLimit(int startPosition) {
		// TODO Auto-generated method stub
		return supplierDAO.findLimit(startPosition);
	}

	@Override
	public Boolean checkExistByName(String name) {
		// TODO Auto-generated method stub
		return supplierDAO.checkExistByName(name);
	}
}