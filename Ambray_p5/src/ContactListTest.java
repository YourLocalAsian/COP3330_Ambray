import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    //List Lengths
    @Test
    public void addingItemsIncreasesSize(){
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
    public void newListIsEmpty(){}

    @Test
    public void removingItemsDecreasesSize(){}

    @Test
    public void removingItemsFailsWithInvalidIndex(){}


    //Editing Tests
    @Test
    public void editingItemsFailsWithAllBlankValues(){}

    @Test
    public void editingItemsFailsWithInvalidIndex(){}

    @Test
    public void editingSucceedsWithBlankFirstName(){}

    @Test
    public void editingSucceedsWithBlankLastName(){}

    @Test
    public void editingSucceedsWithBlankPhone(){}

    @Test
    public void editingSucceedsWithNonBlankValues(){}





    @Test
    public void savedContactListCanBeLoaded(){}


}