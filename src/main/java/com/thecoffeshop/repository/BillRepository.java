package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>, JpaSpecificationExecutor<Bill> {
    List<Bill> findAllByIsdelete(Boolean aBoolean);
    @Query(
            value = "SELECT * FROM bill e where e.ISDELETE = ?1 LIMIT ?2,?3",
            nativeQuery = true
    )
    List<Bill> findAllByLimit(Boolean aBoolean, int start, int index);
    @Query(
            value = "select * from bill b where b.billstatusid = ?1",
            nativeQuery = true
    )
    List<Bill> checkExistBillStatus(String billStatusId);
    @Query(
            value = "select * from bill b where b.voucherid= ?1",
            nativeQuery = true
    )
    List<Bill> checkExistVoucher(Integer voucherId);
    @Query(
            value = "select * from bill b where b.dinnertableid= ?1",
            nativeQuery = true
    )
    List<Bill> checkExistDinnerTable(Integer dinnerTableId);

    @Query(
            value = "select * from bill b where b.billstatusid = ?1 and b.customerid = ?2",
            nativeQuery = true
    )
    Bill checkExistBillStatusAndCustomerId(String billStatusId, Integer customerId);
    @Query(
            value = "select * from bill b where b.customerid = ?1",
            nativeQuery = true
    )
    List<Bill> getBillByCustomerId(int customerid);
}
