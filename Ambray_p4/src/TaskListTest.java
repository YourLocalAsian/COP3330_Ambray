import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    //List Lengths
    @Test
    public void addingTaskItemsIncreasesSize(){}

    @Test
    public void newTaskListIsEmpty(){}

    @Test
    public void removingTaskItemsDecreasesSize(){}

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){}

    //Completing Tasks
    @Test
    public void completingTaskItemChangesStatus(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task1 = new TaskItem("First", "Description", "2001-07-26");
            taskList.getTaskItems().add(task1);
            taskList.completeTaskItem(0);
            assertEquals(true, taskList.getTaskItems().get(0).getTaskCompletionStatus());
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task1 = new TaskItem("First", "Description", "2001-07-26");
            taskList.getTaskItems().add(task1);
            taskList.completeTaskItem(1);
            assertEquals(true, taskList.getTaskItems().get(0).getTaskCompletionStatus());
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());

        }
    }

    //Uncompleting Tasks
    @Test
    public void uncompletingTaskItemChangesStatus(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task1 = new TaskItem("First", "Description", "2001-07-26");
            taskList.getTaskItems().add(task1);
            taskList.completeTaskItem(0);
            taskList.uncompleteTaskItem(0);
            assertEquals(false, taskList.getTaskItems().get(0).getTaskCompletionStatus());
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task1 = new TaskItem("First", "Description", "2001-07-26");
            taskList.getTaskItems().add(task1);
            taskList.completeTaskItem(0);
            taskList.uncompleteTaskItem(1);
            assertEquals(false, taskList.getTaskItems().get(0).getTaskCompletionStatus());
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }


    //Editing Fields
    @Test
    public void editingTaskItemTitleChangesValue(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemTitle(0, "Modified Title");
            assertEquals("Modified Title", taskList.getTaskTitle(0));
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemTitle(1, "Modified Title");
            assertEquals("Modified Title", taskList.getTaskTitle(1));
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDescription(0, "Modified Description");
            assertEquals("Modified Description", taskList.getTaskDescription(0));
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDescription(1, "Modified Description");
            assertEquals("Modified Description", taskList.getTaskDescription(1));
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDueDate(0, "2020-01-01");
            LocalDate newDate = LocalDate.parse("2020-01-01");
            assertEquals(newDate, taskList.getTaskDueDate(0));
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDueDate(1, "2020-01-01");
            LocalDate newDate = LocalDate.parse("2020-01-01");
            assertEquals(newDate, taskList.getTaskDueDate(1));
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    //Getting Fields
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            assertEquals("Original Title", taskList.getTaskTitle(0));
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            assertEquals("Original Title", taskList.getTaskTitle(1));
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            assertEquals("Original Description", taskList.getTaskDescription(0));
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            assertEquals("Original Description", taskList.getTaskDescription(1));
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            assertEquals(LocalDate.parse("2001-07-26"), taskList.getTaskDueDate(0));
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            assertEquals(LocalDate.parse("2001-07-26"), taskList.getTaskDueDate(1));
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void savedTaskListCanBeLoaded(){}

}