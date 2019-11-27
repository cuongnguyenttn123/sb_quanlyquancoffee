package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer>, JpaSpecificationExecutor<Register> {
    @Query(
            value = "select * from register r WHERE r.date >= ?1 AND r.date <= ?2 AND r.isdelete = ?3",
            nativeQuery = true
    )
    List<Register> getListRegisterOnWeek(Date from, Date to, Boolean aBoolean);

    @Query(
            value = "select * from register r WHERE r.scheduleid = ?1 AND r.isdelete = ?2;",
            nativeQuery = true
    )
    List<Register> checkExistSchedule(String scheduleid, Boolean aBoolean);

    @Query(
            value = "select * from register r WHERE r.date = ?1 AND r.scheduleid = ?2 AND r.isdelete = ?3",
            nativeQuery = true
    )
    List<Register> listByDateScheduleid(Date date, String scheduleid, Boolean aBoolean);
}