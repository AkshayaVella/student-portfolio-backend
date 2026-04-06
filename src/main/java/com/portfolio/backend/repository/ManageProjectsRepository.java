package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.model.ManageProjects;

public interface ManageProjectsRepository extends JpaRepository<ManageProjects, Long> {
}