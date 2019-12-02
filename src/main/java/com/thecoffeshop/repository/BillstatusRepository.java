package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Billstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BillstatusRepository extends JpaRepository<Billstatus, String>, JpaSpecificationExecutor<Billstatus> {
    List<Billstatus> findAllByIsdelete(Boolean aBoolean);
    @Query(
            value = "SELECT * FROM billstatus e where e.ISDELETE = ?1 LIMIT ?2,?3",
            nativeQuery = true
    )
    List<Billstatus> findAllByLimit(Boolean aBoolean, int startposition, int index);
}
