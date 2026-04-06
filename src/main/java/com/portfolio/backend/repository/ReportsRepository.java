package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.model.Reports;

import java.util.List;

public interface ReportsRepository extends JpaRepository<Reports, Long> {

    // 🔥 Filter by type (important)
    List<Reports> findByType(String type);
}