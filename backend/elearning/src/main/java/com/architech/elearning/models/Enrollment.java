package com.architech.elearning.models;

import jakarta.persistence.Entity;

@Entity
public class Enrollment {
    
    private Integer id;

    private User userId;

    private Course courseId;
}
