package com.thecoffeshop.service;

import com.thecoffeshop.DAO.CategoryProductDAO;
import com.thecoffeshop.DAO.ProductDAO;
import com.thecoffeshop.DAOImpl.ProductDAOImp;
import com.thecoffeshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class ProductService implements ProductDAOImp {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryProductDAO categoryProductDAO;

	@Override
	public Boolean addProduct(Product product) {

		return productDAO.addProduct(product);
	}

	@Override
	public Product getInfoById(String PId) {

		return productDAO.getInfoById(PId);
	}

	@Override
	public List<Product> getListProductLimit(int startPosition, String cgPrdId, String strSearch, String productid) {

		return productDAO.getListProductLimit(startPosition, cgPrdId, strSearch, productid);
	}

	@Override
	public Boolean checkIsNewProduct(String PId) {

		return productDAO.checkIsNewProduct(PId);
	}

	@Override
	public Boolean deleteProduct(String productid) {
		// TODO Auto-generated method stub
		return productDAO.deleteProduct(productid);
	}

	@Override
	public Boolean editProduct(Product product) {
		// TODO Auto-generated method stub
		return productDAO.editProduct(product);
	}

	@Override
	public int getSizePage() {
		return productDAO.getSizePage();
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDAO.findAll();
	}

	@Override
	public Boolean checkExistNameProduct(String name) {
		// TODO Auto-generated method stub
		return productDAO.checkExistNameProduct(name);
	}

	@Override
	public Boolean checkExistCategoryProduct(String categoryproductid) {
		// TODO Auto-generated method stub
		return productDAO.checkExistCategoryProduct(categoryproductid);
	}

	@Override
	public List<Product> findLimit(int startPosition) {
		// TODO Auto-generated method stub
		return productDAO.findLimit(startPosition);
	}

}
