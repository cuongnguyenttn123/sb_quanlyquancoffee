package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Bill;
import com.thecoffeshop.entity.Billdetail;
import com.thecoffeshop.entity.BilldetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Repository
public interface BilldetailRepository extends JpaRepository<Billdetail, BilldetailId>, JpaSpecificationExecutor<Billdetail> {

    @Query(value = "select * from billdetail b where b.billid = ?1 and b.isdelete = ?2",
            nativeQuery = true
    )
    List<Billdetail> findAllBilldetailByBillid(Integer billid, Boolean isDelete);
    Billdetail findByIdAndIsdelete(BilldetailId billdetailId, Boolean aBoolean);

}
