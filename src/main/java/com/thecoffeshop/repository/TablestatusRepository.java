package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Tablestatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TablestatusRepository extends JpaRepository<Tablestatus, Integer>, JpaSpecificationExecutor<Tablestatus> {
    List<Tablestatus> findAllByIsdelete(Boolean aBoolean);

    Tablestatus findByName(String name);

    @Query(
            value = "select * from tablestatus t where t.isdelete = ?1 limit ?2, ?3",
            nativeQuery = true
    )
    List<Tablestatus> findAllLimit(Boolean aBoolean, int start, int index);
}