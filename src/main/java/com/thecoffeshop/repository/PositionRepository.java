package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends JpaRepository<Position, String>, JpaSpecificationExecutor<Position> {
    List<Position> findAllByIsdelete(Boolean aBoolean);

    @Query(
            value = "select * from position p where p.isdelete = ?1 limit ?2, ?3",
            nativeQuery = true
    )
    List<Position> findAllLimit(Boolean aBoolean, int start, int index);

    Position findByIsdeleteAndName(Boolean aBoolean, String name);
}