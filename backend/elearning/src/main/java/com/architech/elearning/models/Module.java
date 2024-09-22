package com.architech.elearning.models;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Getter
    @NotBlank(message = "Module name is required")
    private String moduleName;

    @Setter @Getter
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Setter @Getter
    @OneToMany(mappedBy = "lesson", cascade = CascadeType.ALL)
    private List<Lesson> lesson;

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", moduleName='" + moduleName + '\'' +
                ", course='" + course + '\'' +
                ", lesson='" + lesson + '\'' +
                '}';
    }

}
