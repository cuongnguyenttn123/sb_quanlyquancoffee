package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Employee;
import com.thecoffeshop.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer>, JpaSpecificationExecutor<Salary> {
    @Query(
            value = "select * from salary s where s.employeeid = ?1 order by s.startdate desc limit 1;",
            nativeQuery = true
    )
    Salary getSalaryByEmployeeId(int employeeid);

    Salary findBySalaryidAndIsdelete(int id, Boolean aBoolean);
}