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
    public void editingTaskItemTitleChangesValue(){}

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){}

    @Test
    public void editingTaskItemDescriptionChangesValue(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("First", "Original", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDescription(0, "Modified");
            assertEquals("Modified", taskList.getTaskItems().get(0).getTaskDescription());
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("First", "Original", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDescription(1, "Modified");
            assertEquals("Modified", taskList.getTaskItems().get(0).getTaskDescription());
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void editingTaskItemDueDateChangesValue(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original", "Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDueDate(0, "2020-01-01");
            LocalDate newDate = LocalDate.parse("2020-01-01");
            assertEquals(newDate, taskList.getTaskItems().get(0).getTaskDueDate());
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original", "Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDueDate(1, "2020-01-01");
            LocalDate newDate = LocalDate.parse("2020-01-01");
            assertEquals(newDate, taskList.getTaskItems().get(0).getTaskDueDate());
        } catch (Exception e) {
            final String failMessage = "Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }


    //Getting Fields
    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){}

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){}

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){}

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){}

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){}

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){}




    @Test
    public void savedTaskListCanBeLoaded(){}



}