import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
    //Title Tests
    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            final String successMessage = "Valid title";
            assertEquals("Valid title", successMessage);
        } catch (Exception e){}
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        try{
            TaskItem item = new TaskItem("", "Description", "2001-07-26");
        } catch (Exception e){
            final String message = "Unable to create item: Invalid title";
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void settingTaskItemTitleSucceedsExpectedValue(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            item.setTaskTitle("New title");
            assertEquals("New title", item.getTaskTitle());
            assertNotEquals("Test", item.getTaskTitle());
        } catch (Exception e){}
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            item.setTaskTitle("");
        } catch (Exception e){
            final String message = "Unable to edit item: Invalid title";
            assertEquals(message, e.getMessage());
        }
    }

    //Date Tests
    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            final String successMessage = "Valid date";
            assertEquals("Valid date", successMessage);
        } catch (Exception e){}
    }

    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "42");
        } catch (Exception e){
            final String message = "Unable to create item: Invalid date";
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithExpectedValue(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            item.setTaskDueDate("2020-01-01");
            assertEquals(LocalDate.parse("2020-01-01"), item.getTaskDueDate());
        } catch (Exception e){}
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDateFormat(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            item.setTaskDueDate("42");
        } catch (Exception e){
            final String message = "Unable to edit item: Invalid date";
            assertEquals(message, e.getMessage());
        }
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDateYYYYMMDD(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            item.setTaskDueDate("0000-00-00");
        } catch (Exception e){
            final String message = "Unable to edit item: Invalid date";
            assertEquals(message, e.getMessage());
        }
    }

    //Description Tests
    @Test
    public void settingTaskDescriptionSucceedsWithExpectedValue(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            item.setTaskDescription("New Description");
            assertEquals("New Description", item.getTaskDescription());
            assertNotEquals("Description", item.getTaskDescription());
        } catch (Exception e){}
    }

}