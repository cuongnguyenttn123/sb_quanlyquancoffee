package com.thecoffeshop.service;

import com.thecoffeshop.DAO.CustomerDAO;
import com.thecoffeshop.DAOImpl.CustomerDAOImp;
import com.thecoffeshop.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class CustomerService implements CustomerDAOImp {

	@Autowired
	CustomerDAO customerDAO;

	@Override
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.addCustomer(customer);
	}

	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return customerDAO.findAll();
	}

	@Override
	public Customer getInfoById(int customerid) {
		// TODO Auto-generated method stub
		return customerDAO.getInfoById(customerid);
	}

	@Override
	public Boolean deleteCustomer(int customerid) {
		// TODO Auto-generated method stub
		return customerDAO.deleteCustomer(customerid);
	}

	@Override
	public int editCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.editCustomer(customer);
	}

	@Override
	public Customer checkPhoneOfCustommer(Integer phone, String pass) {
		return customerDAO.checkPhoneOfCustommer(phone, pass);
	}

}
