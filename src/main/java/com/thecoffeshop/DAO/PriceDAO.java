package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.PriceDAOImp;
import com.thecoffeshop.entity.Price;
import com.thecoffeshop.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PriceDAO implements PriceDAOImp {
	@Autowired
	PriceRepository priceRepository;

	@Override
	public Boolean addPrice(Price price) {
		Boolean aBoolean;
		try{
			priceRepository.save(price);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Price getInfoById(Integer prId) {
		return priceRepository.findById(prId).get();
	}

	@Override
	public Price getInfoByProduct(Integer PId) {
		Price price;
		try {
			price = priceRepository.getInfoByProduct(PId, this.IS_NOT_DELETE);
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			price = null;
		}
		return price;
	}

	@Override
	public Price getSinglePriceOfBillDetail(Integer product, Boolean aBoolean, Date startdatetime) {
		return priceRepository.getSinglePriceOfBillDetail(product, aBoolean, 1);
	}

	@Override
	public Boolean editPrice(Price price) {
		Boolean aBoolean;
		try{
			priceRepository.save(price);
			aBoolean = true;
		}catch (Exception e){
			e.printStackTrace();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			aBoolean = false;
		}
		return aBoolean;
	}

	@Override
	public Price getNewPrice(Integer PId) {
		Date now = new Date();
		try {
			Price price = priceRepository.getNewPrice(PId, this.IS_NOT_DELETE, now);
			return price;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int getOldPrice(Integer PId) {
		Date now = new Date();
		try {
			List<Price> prices = priceRepository.getOldPrice(PId, this.IS_NOT_DELETE, now);
			Price price = prices.get(0);
			return price.getPrice();
		} catch (Exception e) {
			return 0;
		}
	}
}
