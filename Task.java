package task_service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    void testTaskCreationSuccess() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        assertEquals("1234567890", task.getTaskId());
        assertEquals("Task Name", task.getName());
        assertEquals("Task Description", task.getDescription());
    }

    @Test
    void testTaskIdNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task(null, "Task Name", "Task Description"));
    }

    @Test
    void testTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task("12345678901", "Task Name", "Task Description"));
    }

    @Test
    void testTaskIdExactly10Characters() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        assertEquals("1234567890", task.getTaskId());
    }

    @Test
    void testNameNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task("1234567890", null, "Task Description"));
    }

    @Test
    void testNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task("1234567890", "This name is way too long for the requirements", "Task Description"));
    }

    @Test
    void testNameExactly20Characters() {
        String name = "12345678901234567890";
        Task task = new Task("1234567890", name, "Task Description");
        assertEquals(name, task.getName());
    }

    @Test
    void testDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task("1234567890", "Task Name", null));
    }

    @Test
    void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Task("1234567890", "Task Name",
                "This description is way too long and exceeds the fifty character limit"));
    }

    @Test
    void testDescriptionExactly50Characters() {
        String description = "12345678901234567890123456789012345678901234567890";
        Task task = new Task("1234567890", "Task Name", description);
        assertEquals(description, task.getDescription());
    }

    @Test
    void testSetNameSuccess() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        task.setName("New Name");
        assertEquals("New Name", task.getName());
    }

    @Test
    void testSetNameNull() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
    }

    @Test
    void testSetNameTooLong() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        assertThrows(IllegalArgumentException.class, () ->
            task.setName("This name is way too long for the requirements"));
    }

    @Test
    void testSetDescriptionSuccess() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        task.setDescription("New Description");
        assertEquals("New Description", task.getDescription());
    }

    @Test
    void testSetDescriptionNull() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
    }

    @Test
    void testSetDescriptionTooLong() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        assertThrows(IllegalArgumentException.class, () ->
            task.setDescription("This description is way too long and exceeds the fifty character limit"));
    }

    @Test
    void testTaskIdNotUpdatable() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        String originalId = task.getTaskId();
        task.setName("Updated Name");
        task.setDescription("Updated Description");
        assertEquals(originalId, task.getTaskId());
    }

    @Test
    void testMultipleFieldUpdates() {
        Task task = new Task("1234567890", "Task Name", "Task Description");
        task.setName("New Name");
        task.setDescription("New Description");
        assertEquals("1234567890", task.getTaskId());
        assertEquals("New Name", task.getName());
        assertEquals("New Description", task.getDescription());
    }
}
