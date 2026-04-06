package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.model.AssignTasks;

public interface AssignTasksRepository extends JpaRepository<AssignTasks, Long> {
}