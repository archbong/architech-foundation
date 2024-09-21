package com.architech.elearning.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "user_profiles")
public class UserProfile implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 255)
    private String profilePicture;

    @Column
    private Date lastLogin;

    // Constructors, Getters, Setters

    public UserProfile() {}

    public UserProfile(Integer id, User user, String profilePicture, Date lastLogin) {
        this.id = id;
        this.user = user;
        this.profilePicture = profilePicture;
        this.lastLogin = lastLogin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "user=" + user +
                ", profilePicture='" + profilePicture + '\'' +
                ", lastLogin=" + lastLogin +
                '}';
    }
}
