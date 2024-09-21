package com.architech.elearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.architech.elearning.models.gamification.Progress;

public interface ProgressRepository extends JpaRepository<Progress, Long>{
    // Custom query methods can be defined here if needed
    
}
