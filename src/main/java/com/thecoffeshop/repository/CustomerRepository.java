package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Bill;
import com.thecoffeshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
    List<Customer> findAllByIsdelete(Boolean aBoolean);
    @Query(
            value = "select * from customer c where c.phone = ?1",
            nativeQuery = true
    )
    Customer findByPhone(Integer phone);
    Customer getCustomerByBills(Bill bill);
}