package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.model.Settings;

public interface SettingsRepository extends JpaRepository<Settings, Long> {
}