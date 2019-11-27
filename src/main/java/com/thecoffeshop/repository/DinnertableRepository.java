package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Dinnertable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DinnertableRepository extends JpaRepository<Dinnertable, Integer>, JpaSpecificationExecutor<Dinnertable> {
    List<Dinnertable> findAllByIsdelete(Boolean aBoolean);
    @Query(
            value = "select * from dinnertable d where d.tablestatusid = ?1  and isdelete = ?2",
            nativeQuery = true
    )
    List<Dinnertable> findAllTableEmply(int tablestatus, Boolean isNotDelete);

    @Query(
            value = "select * from dinnertable d where d.isdelete = ?1 limit ?2, ?3",
            nativeQuery = true
    )
    List<Dinnertable> findAllByLimit(Boolean aBoolean, int start, int index);

    @Query(
            value = "select * from dinnertable d where d.isdelete = ?1 group by d.countchair",
            nativeQuery = true
    )
    List<Dinnertable> findAllCountChair(Boolean aBoolean);
    @Query(
            value = "select * from dinnertable d where d.name like = ?1",
            nativeQuery = true
    )
    Dinnertable checkExistDinnerTable(String name);
}