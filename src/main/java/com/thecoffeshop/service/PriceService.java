package com.thecoffeshop.service;

import com.thecoffeshop.DAO.PriceDAO;
import com.thecoffeshop.DAOImpl.PriceDAOImp;
import com.thecoffeshop.entity.Price;
import com.thecoffeshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class PriceService implements PriceDAOImp {

	@Autowired
	private PriceDAO priceDAO;

	@Override
	public Boolean addPrice(Price price) {
		return priceDAO.addPrice(price);
	}

	@Override
	public Price getInfoById(Integer prId) {
		return priceDAO.getInfoById(prId);
	}

	@Override
	public Price getInfoByProduct(String PId) {

		return priceDAO.getInfoByProduct(PId);
	}

	@Override
	public Price getSinglePriceOfBillDetail(String product, Boolean aBoolean, Date startdatetime) {
		return priceDAO.getSinglePriceOfBillDetail(product, aBoolean, startdatetime);
	}

	@Override
	public Price getNewPrice(String PId) {

		return priceDAO.getNewPrice(PId);
	}

	@Override
	public int getOldPrice(String PId) {
		return priceDAO.getOldPrice(PId);
	}

	@Override
	public Boolean editPrice(Price price) {
		// TODO Auto-generated method stub
		return priceDAO.editPrice(price);
	}
}
