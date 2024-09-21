package com.architech.elearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architech.elearning.models.Community;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
    // custom query methods can be defined here if needed
}
