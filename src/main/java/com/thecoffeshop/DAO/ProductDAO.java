package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.ProductDAOImp;
import com.thecoffeshop.entity.Categoryproduct;
import com.thecoffeshop.entity.Product;
import com.thecoffeshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductDAO implements ProductDAOImp {
	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryProductDAO categoryProductDAO;

	@Autowired
	EntityManagerFactory entityManagerFactory;

	@Override
	public Boolean addProduct(Product product) {
		Boolean aBoolean;
		try{
			productRepository.save(product);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAllByIsdelete(this.IS_NOT_DELETE);
	}

	@Override
	public List<Product> findLimit(int start) {
		List<Product> productList;
		try{
			productList = productRepository.findAllByLimit(this.IS_NOT_DELETE, start*this.MAX_RESULTS, this.MAX_RESULTS);
		}catch (Exception e){
			e.printStackTrace();
			productList = null;
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return productList;
	}

	@Override
	public List<Product> getListProductLimit(int start, String cgPrdId, String strSearch, String productid) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			String hql = "FROM Product p WHERE p.isdelete =:isdelete";
			if (cgPrdId != null ) {
				hql = hql + " AND p.categoryproduct =:categoryproduct ";
			}
			if (strSearch != null ) {
				hql = hql + " AND p.name =:name ";
			}
			if (productid != null ) {
				hql = hql + " AND p.productid =:productid ";
			}
			System.out.println(hql);
			Query query = entityManager.createQuery(hql);

			query.setParameter("isdelete", this.IS_NOT_DELETE);
			if (cgPrdId != null) {
				query.setParameter("categoryproduct",categoryProductDAO.getInfoById(cgPrdId) );
			}
			if (strSearch != null) {
				query.setParameter("name", strSearch);
			}
			if (productid != null) {
				query.setParameter("productid", productid);
			}
			query.setFirstResult(start* NUM_PRODUCT_ONE_PAGE);
			query.setMaxResults(NUM_PRODUCT_ONE_PAGE);
			List<Product> products = query.getResultList();
			return products;
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public Boolean checkExistCategoryProduct(String categoryproductid) {
		Boolean aBoolean;
		List<Product> products;
		try{
			products = productRepository.checkExistCategoryProduct(categoryproductid, this.IS_NOT_DELETE);
			if (products.size() > 0) {
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
	public Product getInfoById(String productid) {
		return productRepository.findByIsdeleteAndProductid(this.IS_NOT_DELETE,productid);
	}

	@Override
	@Transactional(noRollbackFor = Exception.class)
	public Boolean checkExistNameProduct(String name) {
		Boolean aBoolean;
		Product product;
		try{
			product = productRepository.checkExistNameProduct(name, this.IS_NOT_DELETE);
			if (product != null){
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
	public Boolean checkIsNewProduct(String productid) {

		try {
			Product product = productRepository.findByIsdeleteAndProductid(this.IS_NOT_DELETE, productid);
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(product.getUpdateat());
			c2.setTime(new Date());
			long numDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
			if (numDay <= 7) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Boolean deleteProduct(String productid) {
		Boolean aBoolean;
		try{
			productRepository.deleteById(productid);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Boolean editProduct(Product product) {
		Boolean aBoolean;
		try{
			productRepository.save(product);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public int getSizePage() {
		return productRepository.getSizePage(this.IS_NOT_DELETE);
	}
}
