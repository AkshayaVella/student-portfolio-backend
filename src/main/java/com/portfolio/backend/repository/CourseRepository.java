package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {}