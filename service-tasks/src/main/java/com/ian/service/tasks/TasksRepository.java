package com.ian.service.tasks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<TasksEntity, Long> {
    @Query("select t from Task t where t.dueDate <= :deadline and t.notified = false")
    List<TasksEntity> findTasksDueWithinDeadline(LocalDateTime deadline);
}
