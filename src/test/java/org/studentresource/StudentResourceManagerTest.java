package org.studentresource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentResourceManagerTest {
    private StudentResourceManager<Course> manager;

    @BeforeEach
    void setUp() {
        manager = new StudentResourceManager<>();
    }

    @Test
    void addAndRetrieveResourceTest() {
        Course course = new Course("CS101", "Introduction to Computer Science");
        manager.addResource(course);

        Course retrieved = manager.getResource("CS101");
        assertNotNull(retrieved, "Retrieved course should not be null.");
        assertEquals("Introduction to Computer Science", retrieved.getName(), "Course name should match.");
    }

    @Test
    void removeResourceTest() {
        Course course = new Course("CS101", "Introduction to Computer Science");
        manager.addResource(course);
        StudentResourceManager<Course> newManager = (StudentResourceManager<Course>) manager.clone();
        manager.removeResource(course);
        assertNotEquals(manager, newManager, "Lists should not be the same.");

    }


}
