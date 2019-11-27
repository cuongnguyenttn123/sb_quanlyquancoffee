package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Categoryproduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryProductRepository extends JpaRepository<Categoryproduct, String>, JpaSpecificationExecutor<Categoryproduct> {
    Categoryproduct findByIsdeleteAndCategoryproductid(Boolean a, String cgPId);
    List<Categoryproduct> findAllByIsdelete(Boolean aBoolean);

    @Query(value = "select * from categoryproduct c where c.isdelete = ?1 limit ?2,?3",
    nativeQuery = true)
    List<Categoryproduct> findAllByLimit(Boolean aBoolean, int start, int index);
}
