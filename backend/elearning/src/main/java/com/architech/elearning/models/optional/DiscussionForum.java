package com.architech.elearning.models.optional;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "discussion_forum")
public class DiscussionForum {
    
    @Id
    private Long id;
}
