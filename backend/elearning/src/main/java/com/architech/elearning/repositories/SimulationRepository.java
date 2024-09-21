package com.architech.elearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architech.elearning.models.gamification.Simulation;

@Repository
public interface SimulationRepository extends JpaRepository<Simulation, Long> {
    // Custom query methods can be defined here if needed
}
