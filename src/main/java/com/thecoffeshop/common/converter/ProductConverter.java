package com.thecoffeshop.common.converter;

import com.thecoffeshop.DTO.ProductDTO;
import com.thecoffeshop.entity.Image;
import com.thecoffeshop.entity.Price;
import com.thecoffeshop.entity.Product;
import com.thecoffeshop.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductConverter {

    public List<ProductDTO> converterDAOtoDTO(List<Product> productList){
        ProductConverter productConverter = new ProductConverter();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product: productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductid(product.getProductid());
            productDTO.setName(product.getName());
            productDTO.setPrice(productConverter.getPriceBySet(product.getPrices()));
            Set<Image> setImages = product.getImages();
            List<Image> images = new ArrayList<Image>();
            int size = setImages.size() - 1;
            for (Image image : setImages) {
                if (size <= 3) {
                    images.add(image);
                }
                size--;
            }
            productDTO.setImages(images);

            productDTO.setCategoryproductNAME(product.getCategoryproduct().getName());
            productDTOS.add(productDTO);
            System.out.println(productDTO.getName());
        }
        return productDTOS;
    }

    public int getPriceBySet(Set<Price> priceSet){
        Price price = null;
        int i = 0;
        for (Price  price1: priceSet) {
            if (i == 0){
                price = price1;
            }else {
                if (price.getStartdatetime().before(price1.getStartdatetime())){
                    price = price1;
                }
            }
            i++;

        }
        return price.getPrice();
    }
}
