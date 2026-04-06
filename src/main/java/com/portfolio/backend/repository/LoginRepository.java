package com.portfolio.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.backend.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Login findByEmailAndPassword(String email, String password);
}