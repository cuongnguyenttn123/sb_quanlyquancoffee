package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {
    List<Customer> findAllByIsdelete(Boolean aBoolean);
}