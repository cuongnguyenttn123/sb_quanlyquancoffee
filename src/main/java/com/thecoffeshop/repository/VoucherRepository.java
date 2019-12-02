package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepository extends JpaRepository<Voucher, Integer>, JpaSpecificationExecutor<Voucher> {
    List<Voucher> findAllByIsdelete(Boolean aBoolean);

    @Query(
            value = "select * from voucher v where v.isdelete = ?1 limit ?2, ?3",
            nativeQuery = true
    )
    List<Voucher> findAllLimit(Boolean aBoolean, int start, int index);
    Voucher findByName(String name);
}