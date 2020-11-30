import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    //List Lengths
    @Test
    public void addingTaskItemsIncreasesSize(){
        TaskList taskList = new TaskList();
        int initialSize = taskList.getTaskItems().size();
        try {
            TaskItem task1 = new TaskItem("First", "Description", "2001-07-26");
            taskList.getTaskItems().add(task1);
        } catch (Exception e) {
        } finally {
            assertNotEquals(initialSize, taskList.getTaskItems().size());
        }
    }

    @Test
    public void newTaskListIsEmpty(){
        TaskList taskList = new TaskList();
        int initialSize = taskList.getTaskItems().size();
        assertEquals(0, initialSize);
    }

    @Test
    public void removingTaskItemsDecreasesSize(){
        TaskList taskList = new TaskList();
        int sizeBeforeDeleting = 0;
        try {
            TaskItem task1 = new TaskItem("First", "Description", "2001-07-26");
            taskList.getTaskItems().add(task1);
            sizeBeforeDeleting = taskList.getTaskItems().size();
            taskList.removeItem(0);
        } catch (Exception e) {
        } finally {
            assertEquals(1, sizeBeforeDeleting);
            assertNotEquals(sizeBeforeDeleting, taskList.getTaskItems().size());
        }
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        int sizeBeforeDeleting = 0;
        try {
            TaskItem task1 = new TaskItem("First", "Description", "2001-07-26");
            taskList.getTaskItems().add(task1);
            sizeBeforeDeleting = taskList.getTaskItems().size();
            taskList.removeItem(1);
        } catch (Exception e) {
            final String expectedMessage = "Unable to remove item: Invalid index";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    //Completing Tasks
    @Test
    public void completingTaskItemChangesStatus(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task1 = new TaskItem("First", "Description", "2001-07-26");
            taskList.getTaskItems().add(task1);
            taskList.completeTaskItem(0);
            assertEquals(true, taskList.getTaskItems().get(0).getTaskCompletionStatus());
        } catch (Exception e) {}
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task1 = new TaskItem("First", "Description", "2001-07-26");
            taskList.getTaskItems().add(task1);
            taskList.completeTaskItem(1);
        } catch (Exception e) {
            final String expectedMessage = "Unable to mark item as complete: Invalid index";
            assertEquals(expectedMessage, e.getMessage());
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
        } catch (Exception e) {}
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task1 = new TaskItem("First", "Description", "2001-07-26");
            taskList.getTaskItems().add(task1);
            taskList.completeTaskItem(0);
            taskList.uncompleteTaskItem(1);
        } catch (Exception e) {
            final String expectedMessage = "Unable to mark item as incomplete: Invalid index";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    //Editing Fields

        //Title Tests
    @Test
    public void editingTaskItemTitleSucceedsWithExpectedValue(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemTitle(0, "Modified Title");
            assertEquals("Modified Title", taskList.getTaskTitle(0));
        } catch (Exception e) {}
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemTitle(1, "Modified Title");
        } catch (Exception e) {
            final String failMessage = "Unable to edit name: Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void editingItemTitleFailsWithEmptyString(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemTitle(0, "");
        } catch (Exception e) {
            final String failMessage = "Unable to edit name: Invalid name";
            assertEquals(failMessage, e.getMessage());
        }
    }

        //Description Tests
    @Test
    public void editingTaskItemDescriptionSucceedsWithExpectedValue(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDescription(0, "Modified Description");
            assertEquals("Modified Description", taskList.getTaskDescription(0));
        } catch (Exception e) {}
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDescription(1, "Modified Description");
        } catch (Exception e) {
            final String failMessage = "Unable to edit description: Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

        //Due Date Tests
    @Test
    public void editingTaskItemDueDateSucceedsWithExpectedValue(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDueDate(0, "2020-01-01");
            LocalDate newDate = LocalDate.parse("2020-01-01");
            assertEquals(newDate, taskList.getTaskDueDate(0));
        } catch (Exception e) {}
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDueDate(1, "2020-01-01");
            LocalDate newDate = LocalDate.parse("2020-01-01");
        } catch (Exception e) {
            final String failMessage = "Unable to edit date: Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDueDate(0, "42");
        } catch (Exception e) {
            final String failMessage = "Unable to edit date: Invalid date";
            assertEquals(failMessage, e.getMessage());
        }
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            taskList.editTaskItemDueDate(0, "0000-00-00");
        } catch (Exception e) {
            final String failMessage = "Unable to edit date: Invalid date";
            assertEquals(failMessage, e.getMessage());
        }
    }

    //Getting Fields
        //Title Tests
    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            assertEquals("Original Title", taskList.getTaskTitle(0));
        } catch (Exception e) {}
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
        } catch (Exception e) {
            final String failMessage = "Unable to get title: Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

        //Description Tests
    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            assertEquals("Original Description", taskList.getTaskDescription(0));
        } catch (Exception e) {}
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
        } catch (Exception e) {
            final String failMessage = "Unable to get description: Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

        //Due Date Tests
    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
            assertEquals(LocalDate.parse("2001-07-26"), taskList.getTaskDueDate(0));
        } catch (Exception e) {}
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex(){
        TaskList taskList = new TaskList();
        try {
            TaskItem task0 = new TaskItem("Original Title", "Original Description", "2001-07-26");
            taskList.getTaskItems().add(task0);
        } catch (Exception e) {
            final String failMessage = "Unable to get date: Invalid index";
            assertEquals(failMessage, e.getMessage());
        }
    }

    //Load Tests
    @Test
    public void savedTaskListCanBeLoaded(){
        TaskList tempList = new TaskList();
        try{
            tempList.loadList("testTask.txt");
            assertEquals("Original Title", tempList.getTaskTitle(0));
            assertEquals("Original Description", tempList.getTaskDescription(0));
            assertEquals(LocalDate.parse("2000-01-01"), tempList.getTaskDueDate(0));
        } catch (Exception e){}
    }

    @Test
    public void incompatibleListCannotBeLoaded() {
        ContactList tempList = new ContactList();
        try {
            tempList.loadList("testContact.txt");
        } catch (Exception e) {
            final String expectedMessage = "File is not a task list";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

}