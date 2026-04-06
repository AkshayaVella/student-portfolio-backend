package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.model.AdminSettings;

public interface AdminSettingsRepository extends JpaRepository<AdminSettings, Long> {
}