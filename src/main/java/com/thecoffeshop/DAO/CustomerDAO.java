package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.CustomerDAOImp;
import com.thecoffeshop.entity.Customer;
import com.thecoffeshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CustomerDAO implements CustomerDAOImp {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public int addCustomer(Customer customer) {
		int lastId;
		try {
			customerRepository.save(customer);
			lastId = customer.getCustomerid();
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			lastId = -1;
		}
		return lastId;
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAllByIsdelete(this.IS_NOT_DELETE);
	}

	@Override
	public Customer getInfoById(int customerid) {
		return customerRepository.findById(customerid).get();
	}

	@Override
	public Boolean deleteCustomer(int customerid) {
		Boolean aBoolean;
		try{
			customerRepository.deleteById(customerid);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public int editCustomer(Customer customer) {
		int lastId;
		try {
			customerRepository.save(customer);
			lastId = customer.getCustomerid();
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			lastId = -1;
		}
		return lastId;
	}

	@Override
	public Customer checkPhoneOfCustommer(Integer phone) {
		Customer customer = null;
		try {
			customer = customerRepository.findByPhone(phone);

		}catch (Exception e){
			e.printStackTrace();
		}
		return customer;
	}
}
