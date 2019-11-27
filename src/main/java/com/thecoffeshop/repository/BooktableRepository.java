package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Booktable;
import com.thecoffeshop.entity.BooktableId;
import com.thecoffeshop.entity.Dinnertable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BooktableRepository extends JpaRepository<Booktable, BooktableId>, JpaSpecificationExecutor<Booktable> {
    List<Booktable> findAllByIsdelete(Boolean aBoolean);
    Booktable findByIdAndIsdelete(BooktableId booktableId, Boolean aBoolean);
    List<Booktable> findAllByDinnertable(Dinnertable dinnertable);
    @Query(
            value = "select * from booktable b where b.dinnertableid= ?1",
            nativeQuery = true
    )
    List<Booktable> checkExistDinnerTable(Integer dinnerTableId);
}
