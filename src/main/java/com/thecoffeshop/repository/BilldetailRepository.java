package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Bill;
import com.thecoffeshop.entity.Billdetail;
import com.thecoffeshop.entity.BilldetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BilldetailRepository extends JpaRepository<Billdetail, BilldetailId>, JpaSpecificationExecutor<Billdetail> {

    List<Billdetail> findAllByBill(Bill bill);
    Billdetail findByIdAndIsdelete(BilldetailId billdetailId, Boolean aBoolean);

}
