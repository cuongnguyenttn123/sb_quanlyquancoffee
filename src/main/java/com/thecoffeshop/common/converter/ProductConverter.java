package com.thecoffeshop.common.converter;

import com.thecoffeshop.DTO.ProductDTO;
import com.thecoffeshop.entity.Price;
import com.thecoffeshop.entity.Product;

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
            productDTO.setImage(product.getImage());
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
