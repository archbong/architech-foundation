package com.architech.elearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.architech.elearning.models.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    // Custom query methods can be defined here if needed
}
