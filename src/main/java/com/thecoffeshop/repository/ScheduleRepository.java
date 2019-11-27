package com.thecoffeshop.repository;

import com.thecoffeshop.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String>, JpaSpecificationExecutor<Schedule> {
    List<Schedule> findAllByIsdelete(Boolean aBoolean);

    @Query(
            value = "select * from schedule s where s.isdelete = ?1 limit ?2, ?3",
            nativeQuery = true
    )
    List<Schedule> findAllLimit(Boolean aBoolean, int start, int index);

    Schedule findByIsdeleteAndScheduleid(Boolean aBoolean, String scheduleId);
}