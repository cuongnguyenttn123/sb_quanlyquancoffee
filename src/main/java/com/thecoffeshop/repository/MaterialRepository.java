package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Integer>, JpaSpecificationExecutor<Material> {
    List<Material> findAllByIsdelete(Boolean aBoolean);

    @Query(
            value = "select * from material m where m.isdelete = ?1 limit ?2, ?3",
            nativeQuery = true
    )
    List<Material> findAllLimit(Boolean aBoolean, int start, int index);

    Material findByIsdeleteAndName(Boolean aBoolean, String name);
}