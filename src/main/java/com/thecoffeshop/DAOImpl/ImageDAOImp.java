package com.thecoffeshop.DAOImpl;

import com.thecoffeshop.entity.Image;

import java.util.List;

public interface ImageDAOImp extends CommonDAOImp {

	public List<Image> getListImageOfProduct(String PId);

}
