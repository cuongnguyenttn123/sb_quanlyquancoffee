package com.thecoffeshop.DAOImpl;

import com.thecoffeshop.entity.Price;
import com.thecoffeshop.entity.Product;

import java.util.Date;


public interface PriceDAOImp extends CommonDAOImp {

	public Boolean addPrice(Price price);
	
	public Price getInfoById(Integer prId);
	
	public Price getInfoByProduct(String PId);

	public Price getSinglePriceOfBillDetail(String product, Boolean aBoolean, Date startdatetime);
	
	public Boolean editPrice(Price price);
	
	/*get price will apply*/
	public Price getNewPrice(String PId);
	
	/*get price applied*/
	public int getOldPrice(String PId);
	
}
