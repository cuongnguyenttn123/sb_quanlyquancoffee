package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Importbilldetail;
import com.thecoffeshop.entity.ImportbilldetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImportbilldetailRepository extends JpaRepository<Importbilldetail, ImportbilldetailId>, JpaSpecificationExecutor<Importbilldetail> {

}