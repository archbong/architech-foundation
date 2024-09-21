package com.architech.elearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architech.elearning.models.Assignment;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    // Custom query methods can be defined here if needed
}
