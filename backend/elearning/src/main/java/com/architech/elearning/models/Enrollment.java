package com.architech.elearning.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enrollments")
public class Enrollment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Setter @Getter
    private User userId;

    @Setter @Getter
    private Course courseId;

    @Setter @Getter
    private Enrollment enrollmentDate;

    @Setter @Getter
    private Boolean completionStatus;

    @Setter @Getter
    private Integer progress;

    @Setter @Getter
    @ManyToOne
    private Set<User> user;

    @Setter @Getter
    @ManyToOne
    private Set<Course> course;

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", enrollmentDate='" + enrollmentDate + '\'' +
                ", progress='" + progress + '\'' +
                ", user='" + user + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
