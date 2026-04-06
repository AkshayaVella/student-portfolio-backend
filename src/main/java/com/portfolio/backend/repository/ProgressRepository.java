package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.model.Progress;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
}