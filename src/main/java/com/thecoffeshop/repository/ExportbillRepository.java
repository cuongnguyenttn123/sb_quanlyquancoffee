package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Exportbill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExportbillRepository extends JpaRepository<Exportbill, Integer>, JpaSpecificationExecutor<Exportbill> {
    List<Exportbill> findAllByIsdelete(Boolean aBoolean);

    @Query(
            value = "SELECT * FROM exportbill e where e.ISDELETE = ?1 LIMIT ?2,?3",
            nativeQuery = true
    )
    List<Exportbill> findAllByLimit(Boolean aBoolean, int start, int index);

    @Query(
            value = "select * from exportbill e where e.productid = ?1 and e.quantity >= ?2 and e.isdelete = ?3",
            nativeQuery = true
    )
    List<Exportbill> totalQuantityProduct(String productid, int index, Boolean aBoolean);

    @Query(
            value = "select * from exportbill e where e.productid = ?1 and e.quantityinventory > ?2 and e.isdelete = ?3",
            nativeQuery = true
    )
    List<Exportbill> getListExportBillbyProduct(String productid, int index, Boolean aBoolean);
}