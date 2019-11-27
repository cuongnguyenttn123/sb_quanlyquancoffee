package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>, JpaSpecificationExecutor<Image> {
    @Query(
            value = "select * from image join imageofproduct where imageofproduct.PRODUCTID = ?1 and image.IMAGEID = imageofproduct.IMAGEID;",
            nativeQuery = true
    )
    List<Image> getListImageOfProduct(String productId);

}