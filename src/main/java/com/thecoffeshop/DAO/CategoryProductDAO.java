package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.CategoryProductDAOImp;
import com.thecoffeshop.entity.Categoryproduct;
import com.thecoffeshop.repository.CategoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CategoryProductDAO implements CategoryProductDAOImp {
	@Autowired
	CategoryProductRepository categoryProductRepository;

	@Override
	@Transactional
	public Boolean addCategoryProduct(Categoryproduct categoryproduct) {
		Boolean aBoolean;
		try{
			categoryProductRepository.save(categoryproduct);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public List<Categoryproduct> findAll() {
		return categoryProductRepository.findAllByIsdelete(this.IS_NOT_DELETE);
	}

	@Override
	public List<Categoryproduct> findLimit(int start) {
		return categoryProductRepository.findAllByLimit(this.IS_NOT_DELETE, start*this.MAX_RESULTS, this.MAX_RESULTS);
	}

	@Override
	public Categoryproduct getInfoById(String categoryproductid) {
		Categoryproduct categoryproduct;
		try {
			categoryproduct = categoryProductRepository.findByIsdeleteAndCategoryproductid(this.IS_NOT_DELETE,categoryproductid);
		}catch (Exception e){
			categoryproduct = null;
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return categoryproduct;
	}

	@Override
	public Boolean deleteCategoryproduct(String categoryproductid) {
		Boolean aBoolean;
		try{
			categoryProductRepository.deleteById(categoryproductid);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Boolean editCategoryproduct(Categoryproduct categoryproduct) {
		Boolean aBoolean;
		try{
			categoryProductRepository.save(categoryproduct);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}
}
