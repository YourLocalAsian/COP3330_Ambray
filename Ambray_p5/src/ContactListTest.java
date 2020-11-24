import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ContactListTest {
    //List Lengths
    @Test
    public void addingItemsIncreasesSize(){
        ContactList testList = new ContactList();
        int initialSize = testList.getContacts().size();
        try {
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testList.getContacts().add(testContact);
        } catch (Exception e) {
        } finally {
            assertNotEquals(initialSize, testList.getContacts().size());
        }
    }

    @Test
    public void newListIsEmpty(){
        ContactList testList = new ContactList();
        int initialSize = testList.getContacts().size();
        assertEquals(0, initialSize);
    }

    @Test
    public void removingItemsDecreasesSize(){
        ContactList testList = new ContactList();
        int sizeBeforeDeleting = 0;
        try {
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testList.getContacts().add(testContact);
            sizeBeforeDeleting = testList.getContacts().size();
            testList.removeTaskItem(0);
        } catch (Exception e) {
        } finally {
            assertEquals(1, sizeBeforeDeleting);
            assertNotEquals(sizeBeforeDeleting, testList.getContacts().size());
        }
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        ContactList testList = new ContactList();
        int sizeBeforeDeleting = 0;
        try {
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testList.getContacts().add(testContact);
            sizeBeforeDeleting = testList.getContacts().size();
            testList.removeTaskItem(0);
        } catch (Exception e) {
        } finally {
            assertEquals(1, sizeBeforeDeleting);
            assertNotEquals(sizeBeforeDeleting, testList.getContacts().size());
        }
    }


    //Editing Tests
    @Test
    public void editingSucceedsWithNonBlankValues(){

    }

    @Test
    public void editingSucceedsWithBlankFirstName(){

    }

    @Test
    public void editingSucceedsWithBlankLastName(){

    }

    @Test
    public void editingSucceedsWithBlankPhone(){

    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){

    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){

    }


    //Load Test
    @Test
    public void savedContactListCanBeLoaded(){
        ContactList tempList = new ContactList();
        try{
            tempList.loadTaskList("testContact.txt");
            assertEquals("Tacko", tempList.getFirstName(0));
            assertEquals("Fall", tempList.getLastName(0));
            assertEquals("555-555-5555", tempList.getPhoneNumber(0));
            assertEquals("thetackofall@gmail.com", tempList.getEmailAddress(0));
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}