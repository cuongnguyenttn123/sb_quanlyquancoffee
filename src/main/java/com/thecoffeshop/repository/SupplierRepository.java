package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>, JpaSpecificationExecutor<Supplier> {
    List<Supplier> findAllByIsdelete(Boolean aBoolean);

    @Query(
            value = "select * from supplier s where s.isdelete = ?1 limit ?2, ?3",
            nativeQuery = true
    )
    List<Supplier> findAllLimit(Boolean aBoolean, int start, int index);

    Supplier findByNameAndIsdelete(String name, Boolean aBoolean);
}