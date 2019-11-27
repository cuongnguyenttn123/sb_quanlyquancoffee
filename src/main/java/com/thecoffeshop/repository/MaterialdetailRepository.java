package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Materialdetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialdetailRepository extends JpaRepository<Materialdetail, Integer>, JpaSpecificationExecutor<Materialdetail> {
    List<Materialdetail> findAllByIsdelete(Boolean aBoolean);

    @Query(
            value = "select * from materialdetail m where m.isdelete = ?1 limit ?2, ?3",
            nativeQuery = true
    )
    List<Materialdetail> findAllLimit(Boolean aBoolean, int start, int index);
    @Query(
            value = "select * from materialdetail m where m.isdelete = ?1 and m.materialid",
            nativeQuery = true
    )
    List<Materialdetail> checkExistMaterial(Boolean aBoolean, int materialid);

    Materialdetail findByIsdeleteAndMaterialdetailid(Boolean aBoolean, int materialdetailid);

}