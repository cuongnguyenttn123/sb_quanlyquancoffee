package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
    @Query(
            value = "SELECT * FROM employee e where e.usename = ?1 and e.password = ?2",
            nativeQuery = true
    )
    Employee logIn(String userName, String passWord);
    Employee findByUsename(String useName);
    List<Employee> findAllByIsdelete(Boolean aBoolean);

    @Query(value = "SELECT * FROM employee e WHERE e.ISDELETE = false", nativeQuery = true)
    List<Employee> findAllByDelete();

    @Query(value = "SELECT e FROM Employee e WHERE e.isdelete = true")
    List<Employee> findAllByDelete1();

    @Query("select e from Employee e where e.usename =?1")
    List<Employee> findAllByDelete2(String s);

    @Query(
            value = "SELECT * FROM employee e where e.ISDELETE = ?1 LIMIT ?2,?3",
            nativeQuery = true
    )
    List<Employee> findAllLimit(Boolean aBoolean, int position, int index);

}
