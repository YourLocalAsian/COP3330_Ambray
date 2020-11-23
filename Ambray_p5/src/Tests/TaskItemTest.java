import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            final String successMessage = "Valid title";
            assertEquals("Valid title", successMessage);
        } catch (Exception e){
            final String message = "Invalid title";
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        try{
            TaskItem item = new TaskItem("", "Description", "2001-07-26");
            final String successMessage = "Valid title";
            assertEquals("Valid title", successMessage);
        } catch (Exception e){
            final String message = "Invalid title";
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            item.setTaskTitle("New Title");
            final String successMessage = "Valid title";
            assertEquals("Valid title", successMessage);
        } catch (Exception e){
            final String message = "Invalid title";
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            item.setTaskTitle("");
            final String successMessage = "Valid title";
            assertEquals("Valid title", successMessage);
        } catch (Exception e){
            final String message = "Invalid title";
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            final String successMessage = "Valid date";
            assertEquals("Valid date", successMessage);
        } catch (Exception e){
            final String message = "Invalid date";
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "42");
            final String successMessage = "Valid date";
            assertEquals("Valid date", successMessage);
        } catch (Exception e){
            final String message = "Invalid date";
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            item.setTaskDueDate("2020-01-01");
            final String successMessage = "Valid date";
            assertEquals("Valid date", successMessage);
        } catch (Exception e){
            final String message = "Invalid date";
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            item.setTaskDueDate("42");
            final String successMessage = "Valid date";
            assertEquals("Valid date", successMessage);
        } catch (Exception e){
            final String message = "Invalid date";
            assertEquals(message, e.getMessage());
        }
    }




}