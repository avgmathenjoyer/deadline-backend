package com.example.deadlineproject.repositories;

import com.example.deadlineproject.entities.Deadline;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DeadlineRepository extends JpaRepository<Deadline, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM Deadline WHERE id=:id")
    Integer deleteByDeadlineId(@Param("id") Long id);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Deadline SET title=:#{#deadline.title}, description=:#{#deadline.description}, endDate=:#{#deadline.endDate} WHERE id=:id")
    Integer updateByDeadlineId(@Param("id") Long id, @Param("deadline") Deadline deadline);
}
