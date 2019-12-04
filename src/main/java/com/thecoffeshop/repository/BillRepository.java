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
    @Query(
            value = "select * from bill b where b.dinnertableid = ?1 and b.billstatusid =?2 and b.isdelete = ?3 order by startdatetime DESC limit 1;",
            nativeQuery = true
    )
    Bill getInfoLastBill(int dinnertableid, String billstatusid, Boolean isDelete);

    @Query(
            value = "select * from bill b where  b.billstatusid =?1 and b.isdelete = ?2 order by startdatetime DESC limit 5;",
            nativeQuery = true
    )
    List<Bill> getListUserOrder(String billstatusid, Boolean isDelete);
    @Query(
            value = "select * from bill b where  b.billstatusid =?1 or b.billstatusid =?2 and b.isdelete = ?3 order by startdatetime DESC",
            nativeQuery = true
    )
    List<Bill> getListUserOrderAll(String billstatusid,String billstatusid2, Boolean isDelete);

    @Query(
            value = "select * from bill b where b.employeeid = ?1 and b.billstatusid =?2 and b.isdelete = ?3 order by startdatetime DESC",
            nativeQuery = true
    )
    List<Bill> getListBillShipper(String emId, String billstatusId, Boolean aBoolean);
}
