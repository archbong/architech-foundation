package com.architech.elearning.models;

import java.util.List;
import java.util.Set;

import com.architech.elearning.models.assessment.Quiz;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "lessons")
public class Lesson {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Setter @Getter
    @NotBlank(message = "Title is required.")
    private String title;

    @Setter @Getter
    @NotBlank(message = "Content is required.")
    private String content;

    @Setter @Getter
    @NotBlank(message = "Video URL is required.")
    private String videoUrl;

    @Setter @Getter
    private Long quizId;

    @Setter @Getter
    private Long moduleId;

    @Setter @Getter
    @ManyToMany(mappedBy = "modules", cascade = CascadeType.ALL)
    private Set<Module> modules;

    @Setter @Getter
    @OneToMany(mappedBy = "quizzes", cascade = CascadeType.ALL)
    private List<Quiz> quizzes;

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", quizId='" + quizId + '\'' +
                ", moduleId='" + moduleId + '\'' +
                ", quizzes='" + quizzes + '\'' +
                '}';
    }

}
