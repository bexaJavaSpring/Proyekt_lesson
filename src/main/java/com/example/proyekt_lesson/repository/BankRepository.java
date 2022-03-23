package com.example.proyekt_lesson.repository;

import com.example.proyekt_lesson.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank,Integer> {
}
