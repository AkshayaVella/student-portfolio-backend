package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.model.ManageCourses;

public interface ManageCoursesRepository extends JpaRepository<ManageCourses, Long> {
}