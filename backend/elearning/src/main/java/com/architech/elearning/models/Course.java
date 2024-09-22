package com.architech.elearning.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "courses")
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    @Setter @Getter
    @NotBlank(message = "Course title is required")
    private String title;

    @NotBlank(message = "Description is required")
    @Lob
    @Setter @Getter
    private String description;

    @Setter @Getter
    private String instructor;
    
    @Setter @Getter
    private Integer duration;  // in hours or minutes

    @Setter @Getter
    private String level;

    @Setter @Getter
    private BigDecimal price;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

    @Setter @Getter
    private Boolean published;

    @Setter @Getter
    private String language;

    @Setter @Getter
    private String thumbnailImage;

    @ElementCollection
    private Set<String> tags;

    @OneToMany(mappedBy = "modules", cascade = CascadeType.ALL)
    private Set<Module> modules;

    @OneToMany(mappedBy = "ratings", cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "reviews", cascade = CascadeType.ALL)
    private List<Review> reviews;

    @Setter @Getter
    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Category> category;

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", instructor='" + instructor + '\'' +
                ", duration='" + duration + '\'' +
                ", level='" + level + '\'' +
                ", price='" + price + '\'' +
                ", published='" + published + '\'' +
                ", language='" + language + '\'' +
                ", thumbnailImage='" + thumbnailImage + '\'' +
                ", modules='" + modules + '\'' +
                ", ratings='" + ratings + '\'' +
                ", reviews='" + reviews + '\'' +
                ", category='" + category + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
