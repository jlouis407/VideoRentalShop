package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Clerk;

public interface ClerkRepository extends JpaRepository<Clerk, Long>{

}
