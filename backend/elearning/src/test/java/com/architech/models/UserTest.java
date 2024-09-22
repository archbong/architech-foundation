package com.architech.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.architech.elearning.models.User;
import com.architech.elearning.models.UserProfile;

class UserTest {
    
    private User user;

    @BeforeEach
    void setUp(){
        user = new User();
    }

    @Test
    void testSetAndGetId(){
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    void testSetAndGetFullName(){
        String fullname = "John Doe";
        user.setFullName(fullname);
        assertEquals(fullname, user.getFullName());
    }

    @Test
    void testSetAndGetEmail(){
        String email = "john.doe@example.com";
        user.setEmail(email);
        assertEquals(email, user.getEmail());
    }

    @Test
    void testSetAndGetPassword(){
        String password = "password123";
        user.setPassword(password);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testSetAndGetCreateAt(){
        Date now = new Date();
        user.setCreatedAt(now);
        assertEquals(now, user.getCreatedAt());
    }

    @Test
    void testSetAndGetUserProfile(){
        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);
        assertEquals(userProfile, user.getUserProfile());
    }

    @Test
    void testToString() {
        user.setId(1L);
        user.setFullName("John Doe");
        user.setPassword("password123");
        user.setEmail("john.doe@example.com");
        String expected = "User{id=1, fullName='John Doe', email='john.doe@example.com', password='password123', createdAt=null, updatedAt=null}";
        assertEquals(expected, user.toString());
    }
}
