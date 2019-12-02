package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Atposition;
import com.thecoffeshop.entity.AtpositionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AtpositonRepository extends JpaRepository<Atposition, AtpositionId>, JpaSpecificationExecutor<Atposition> {

    Atposition findByIdAndIsdelete(AtpositionId atpositionId, Boolean aBoolean);

    @Query(value = "select * from atposition a where positionid = ?1", nativeQuery = true)
    List<Atposition> checkExistPosition(String positionId);
}
