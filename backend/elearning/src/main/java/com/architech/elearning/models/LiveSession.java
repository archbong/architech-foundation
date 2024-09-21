package com.architech.elearning.models;


/**
 * LiveSession
 *  Represents scheduled live sessions for real-time interaction between instructors and students.
 *      Fields: id, title, description, courseId, scheduledDate, duration, instructorId, sessionLink.
 *          Relationships:
 *              Many-to-one with Course (live session belongs to a course).
 *              Many-to-one with User (instructor leading the session).
 */
public class LiveSession {
    
}
