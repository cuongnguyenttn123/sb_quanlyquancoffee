package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Price;
import com.thecoffeshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Integer>, JpaSpecificationExecutor<Price> {
    @Query(value = "select * from price p where p.productid = ?1 and p.isdelete = ?2 and p.startdatetime <= ?3 order by p.startdatetime DESC limit ?4",
            nativeQuery = true
    )
    Price getSinglePriceOfBillDetail(String productid, Boolean aBoolean, Date startdatetime, int limit);

    @Query(
            value = "select * from price p where p.productid = ?1 and p.isdelete = ?2",
            nativeQuery = true
    )
    Price getInfoByProduct(String productId, Boolean aBoolean);

    @Query(
            value = "select * from price p where p.productid = ?1 and p.isdelete = ?2 and p.startdatetime > ?3",
            nativeQuery = true
    )
    Price getNewPrice(String productId, Boolean aBoolean, Date date);
    @Query(
            value = "select * from price p where p.productid = ?1 and p.isdelete = ?2 and p.startdatetime < ?3 order by p.startdatetime DESC",
            nativeQuery = true
    )
    List<Price> getOldPrice(String productId, Boolean aBoolean, Date date);
}