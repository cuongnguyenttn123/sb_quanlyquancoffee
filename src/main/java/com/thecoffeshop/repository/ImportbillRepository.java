package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Importbill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ImportbillRepository extends JpaRepository<Importbill, Integer>, JpaSpecificationExecutor<Importbill> {
    List<Importbill> findAllByIsdelete(Boolean aBoolean);

    @Query(
            value = "select * from importbill i where i.isdelete = ?1 limit ?2, ?3",
            nativeQuery = true
    )
    List<Importbill> findAllLimit(Boolean aBoolean, int start, int index);

    List<Importbill> findAllByIsdeleteAndUpdateat(Boolean aBoolean, Date date);
}