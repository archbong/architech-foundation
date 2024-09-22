package com.architech.elearning.models;

import java.util.Date;
import java.util.Set;

import com.architech.elearning.models.assessment.Submission;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "assignment")
@Data
public class Assignment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Setter @Getter
    @NotBlank(message = "Title is required.")
    private String title;

    @Setter @Getter
    @NotBlank(message = "Description is required")
    private String description;

    @Setter @Getter
    private Date dueDate;

    @Setter @Getter
    private Course courseId;

    @Setter @Getter
    @ManyToOne
    private Set<Course> course;

    @OneToMany(mappedBy = "submissions", cascade = CascadeType.ALL)
    private Set<Submission> submission;

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", courseId='" + courseId + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
