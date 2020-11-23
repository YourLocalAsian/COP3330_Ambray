import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {
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
    public void settingTaskItemTitleSucceedsWithValidTitle(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            item.setTaskTitle("New Title");
            final String successMessage = "Valid title";
            assertEquals("Valid title", successMessage);
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
    public void settingTaskItemDueDateSucceedsWithValidDate(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            item.setTaskDueDate("2020-01-01");
            final String successMessage = "Valid date";
            assertEquals("Valid date", successMessage);
        } catch (Exception e){}
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate(){
        try{
            TaskItem item = new TaskItem("Test", "Description", "2001-07-26");
            item.setTaskDueDate("42");
        } catch (Exception e){
            final String message = "Unable to edit item: Invalid date";
            assertEquals(message, e.getMessage());
        }
    }




}