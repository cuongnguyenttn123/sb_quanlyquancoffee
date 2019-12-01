package com.thecoffeshop.DAOImpl;

import com.thecoffeshop.entity.Customer;

import java.util.List;



public interface CustomerDAOImp extends CommonDAOImp{
	
	public int addCustomer(Customer customer);

	public List<Customer> findAll();

	public Customer getInfoById(int customerid);

	public Boolean deleteCustomer(int customerid);

	public int editCustomer(Customer customer);

	public Customer checkPhoneOfCustommer(Integer phone, String pass);
}
