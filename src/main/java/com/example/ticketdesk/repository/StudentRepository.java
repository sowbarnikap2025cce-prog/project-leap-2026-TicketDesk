package com.example.ticketdesk.repository;

import com.example.ticketdesk.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}