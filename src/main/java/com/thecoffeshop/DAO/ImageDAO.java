package com.thecoffeshop.DAO;

import com.thecoffeshop.DAOImpl.ImageDAOImp;
import com.thecoffeshop.entity.Image;
import com.thecoffeshop.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ImageDAO implements ImageDAOImp {
	@Autowired
	ImageRepository imageRepository;

	@Override
	public List<Image> getListImageOfProduct(String ProductId) {
		return imageRepository.getListImageOfProduct(ProductId);
	}
}
