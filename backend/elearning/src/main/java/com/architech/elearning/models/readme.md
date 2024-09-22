# JPA entities or domain models

Defines the JPA entities (e.g., User, Course, Enrollment). These classes map to the database tables.

Building a scalable e-learning web application involves several entities to model the relationships between different aspects like users, courses, assessments, etc. Below is a list of key entities you might need for an e-learning platform, along with a brief description of each entity and how they interrelate.

## Core Entities

1. **User**
   - Represents all types of users in the system (students, instructors, admins).
   - Fields: `id`, `fullName`, `email`, `password`, `role`, `profilePicture`, `lastLogin`.
   - Relationships:
     - One-to-many with `Course` (an instructor creates many courses).
     - Many-to-many with `Course` (students enroll in multiple courses).

2. **Role**
   - Defines different roles a user can have, such as `STUDENT`, `INSTRUCTOR`, or `ADMIN`.
   - Fields: `id`, `roleName`.
   - Relationships:
     - One-to-many with `User` (a user has one role).

3. **Course**
   - Represents a course with content, modules, and assignments.
   - Fields: `id`, `title`, `description`, `startDate`, `endDate`, `level`, `language`, `price`, `status`.
   - Relationships:
     - Many-to-one with `User` (instructor).
     - Many-to-many with `User` (students enrolled).
     - One-to-many with `Module` (a course has multiple modules).
     - Many-to-many with `Category` (a course can belong to multiple categories).
     - One-to-many with `Assignment` (a course has many assignments).

4. **Module**
   - Represents the sections or chapters within a course.
   - Fields: `id`, `title`, `content`, `order`, `courseId`.
   - Relationships:
     - Many-to-one with `Course` (a module belongs to a course).
     - One-to-many with `Lesson` (a module contains many lessons).

5. **Lesson**
   - Represents a specific learning unit within a module.
   - Fields: `id`, `title`, `content`, `videoUrl`, `quizId`, `moduleId`.
   - Relationships:
     - Many-to-one with `Module` (a lesson belongs to a module).
     - One-to-one with `Quiz` (a lesson can have an associated quiz).

6. **Category**
   - Defines categories or subjects for courses, such as `Programming`, `Data Science`, etc.
   - Fields: `id`, `name`, `description`.
   - Relationships:
     - Many-to-many with `Course` (a course can belong to many categories).

7. **Enrollment**
   - Tracks which users are enrolled in which courses.
   - Fields: `id`, `userId`, `courseId`, `enrollmentDate`, `completionStatus`, `progress`.
   - Relationships:
     - Many-to-one with `User` (the student).
     - Many-to-one with `Course` (the course).

### Assessment and Progress Entities

8. **Quiz**
   - A collection of questions that test the student's knowledge of a lesson.
   - Fields: `id`, `title`, `totalScore`, `timeLimit`.
   - Relationships:
     - One-to-one with `Lesson` (a quiz is linked to a lesson).
     - One-to-many with `Question` (a quiz contains many questions).

9. **Question**
   - Represents individual questions in a quiz.
   - Fields: `id`, `questionText`, `type` (e.g., `MULTIPLE_CHOICE`, `TRUE_FALSE`), `correctAnswer`.
   - Relationships:
     - Many-to-one with `Quiz` (a question belongs to a quiz).

10. **Answer**
    - Represents the answer options for multiple-choice questions.
    - Fields: `id`, `answerText`, `isCorrect`, `questionId`.
    - Relationships:
      - Many-to-one with `Question` (a question has multiple answers).

11. **Assignment**
    - Represents course-related assignments or projects.
    - Fields: `id`, `title`, `description`, `dueDate`, `courseId`.
    - Relationships:
      - Many-to-one with `Course` (an assignment belongs to a course).
      - One-to-many with `Submission` (a user can submit assignments).

12. **Submission**
    - Represents a student's submission for an assignment.
    - Fields: `id`, `assignmentId`, `studentId`, `submittedFileUrl`, `grade`, `submittedDate`.
    - Relationships:
      - Many-to-one with `Assignment` (submission belongs to an assignment).
      - Many-to-one with `User` (submission is made by a student).

13. **Grade**
    - Represents the grade a student received for their submission or quiz.
    - Fields: `id`, `gradeValue`, `dateAwarded`, `comments`.
    - Relationships:
      - Many-to-one with `User` (student receiving the grade).
      - Many-to-one with `Submission` or `Quiz` (graded entity).

### Additional Entities

14. **Comment**
    - Allows users to comment on courses, modules, or lessons.
    - Fields: `id`, `content`, `createdDate`, `userId`, `courseId` or `lessonId`.
    - Relationships:
      - Many-to-one with `User` (commenter).
      - Many-to-one with `Course` or `Lesson` (a comment belongs to a course or lesson).

15. **Notification**
    - Sends notifications to users about course updates, assignments, or new lessons.
    - Fields: `id`, `message`, `type`, `read`, `userId`.
    - Relationships:
      - Many-to-one with `User` (notification recipient).

16. **Payment**
    - Handles course purchase and enrollment transactions.
    - Fields: `id`, `userId`, `courseId`, `paymentDate`, `amount`.
    - Relationships:
      - Many-to-one with `User` (the student).
      - Many-to-one with `Course` (the course being purchased).

### Optional Entities (for advanced features)

17. **Certificate**
    - Represents a certificate awarded to a student upon course completion.
    - Fields: `id`, `certificateUrl`, `courseId`, `userId`, `issueDate`.
    - Relationships:
      - Many-to-one with `User` (student awarded the certificate).
      - Many-to-one with `Course` (the completed course).

18. **DiscussionForum**
    - Represents a forum where users can discuss topics related to a course or lesson.
    - Fields: `id`, `title`, `description`, `createdDate`, `courseId`.
    - Relationships:
      - Many-to-one with `Course` (discussion is related to a course).
      - One-to-many with `ForumPost` (forum contains many posts).

19. **ForumPost**
    - Represents posts within a discussion forum.
    - Fields: `id`, `content`, `createdDate`, `userId`, `discussionForumId`.
    - Relationships:
      - Many-to-one with `User` (author of the post).
      - Many-to-one with `DiscussionForum` (post belongs to a forum).

20. **Review**
    - Allows users to review a course and provide feedback.
    - Fields: `id`, `rating`, `comment`, `courseId`, `userId`, `createdDate`.
    - Relationships:
      - Many-to-one with `User` (reviewer).
      - Many-to-one with `Course` (reviewed course).

### Example of Relationships Between Entities

- A **User** can be either a **Student** or an **Instructor**, based on their role.
- A **Course** can have multiple **Modules** and **Assignments**.
- Each **Module** can have multiple **Lessons**.
- A **Lesson** can have an associated **Quiz**.
- A **Student** can enroll in multiple **Courses**, and each **Course** can have multiple **Students**.
- **Students** submit **Assignments** and take **Quizzes**, which result in **Grades**.
- **Courses** can belong to multiple **Categories**.

### Conclusion

This list should provide a comprehensive view of the entities needed for a scalable e-learning web application. Each entity plays a key role in managing users, courses, assessments, and other aspects of the learning platform.

By carefully modeling these entities and their relationships, you can ensure your application is well-structured, scalable, and capable of handling complex workflows.
