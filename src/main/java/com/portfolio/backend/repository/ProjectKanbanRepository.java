package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.model.ProjectKanban;

import java.util.List;

public interface ProjectKanbanRepository extends JpaRepository<ProjectKanban, Long> {

    // ✅ Filter by column
    List<ProjectKanban> findByStatus(String status);
}