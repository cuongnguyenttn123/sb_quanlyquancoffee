package com.thecoffeshop.DAOImpl;

import com.thecoffeshop.entity.Price;

import java.util.Date;


public interface PriceDAOImp extends CommonDAOImp {

	public Boolean addPrice(Price price);
	
	public Price getInfoById(Integer prId);
	
	public Price getInfoByProduct(Integer PId);

	public Price getSinglePriceOfBillDetail(Integer productid, Boolean aBoolean, Date startdatetime);
	
	public Boolean editPrice(Price price);
	
	/*get price will apply*/
	public Price getNewPrice(Integer PId);
	
	/*get price applied*/
	public int getOldPrice(Integer PId);
	
}
