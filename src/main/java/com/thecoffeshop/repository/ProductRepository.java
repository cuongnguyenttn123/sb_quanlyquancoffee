package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    Product findByIsdeleteAndProductid(Boolean aBoolean, Integer productid);
    List<Product> findAllByIsdelete(Boolean aBoolean);

    @Query(value = "select * from product c where c.isdelete = ?1 limit ?2,?3",
            nativeQuery = true)
    List<Product> findAllByLimit(Boolean aBoolean, int start, int index);


    @Query(value = "select * from product c where c.categoryproductid = ?1 and c.isdelete = ?2",
            nativeQuery = true)
    List<Product> checkExistCategoryProduct(String cgPrId, Boolean aBoolean);


    @Query(value = "select * from product c where c.name = ?1 and c.isdelete = ?2",
            nativeQuery = true)
    Product checkExistNameProduct(String name, Boolean aBoolean);

    @Query(value = "select count(*) from product c where c.isdelete = ?1",
            nativeQuery = true)
    int getSizePage(Boolean aBoolean);
}