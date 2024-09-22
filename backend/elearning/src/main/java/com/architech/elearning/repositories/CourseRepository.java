package com.architech.elearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.architech.elearning.models.Course;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    Optional<Course> findByTitle(String courseTitle);
}
