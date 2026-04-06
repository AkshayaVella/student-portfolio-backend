package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
}