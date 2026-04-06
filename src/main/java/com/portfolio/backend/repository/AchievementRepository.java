package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.model.Achievement;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}