import org.junit.jupiter.api.Test;

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
            testList.removeItem(0);
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
            testList.removeItem(0);
        } catch (Exception e) {
        } finally {
            assertEquals(1, sizeBeforeDeleting);
            assertNotEquals(sizeBeforeDeleting, testList.getContacts().size());
        }
    }


    //Editing Tests
    @Test
    public void editingSucceedsWithNonBlankValues(){
        ContactList testList = new ContactList();
        try {
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testList.getContacts().add(testContact);
            testList.editContact(0, "Marshall" ,"Mathers", "313-555-5555", "slimshady@aftermath.com");
        } catch (Exception e) {
        } finally {
            assertNotEquals("Tacko", testList.getFirstName(0));
            assertNotEquals("Fall", testList.getLastName(0));
            assertNotEquals("555-555-5555", testList.getPhoneNumber(0));
            assertNotEquals("thetackofall@gmail.com", testList.getEmailAddress(0));
            assertEquals("Marshall", testList.getFirstName(0));
            assertEquals("Mathers", testList.getLastName(0));
            assertEquals("313-555-5555", testList.getPhoneNumber(0));
            assertEquals("slimshady@aftermath.com", testList.getEmailAddress(0));
        }
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        ContactList testList = new ContactList();
        try {
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testList.getContacts().add(testContact);
            testList.editContact(0, "" ,"Mathers", "313-555-5555", "slimshady@aftermath.com");
        } catch (Exception e) {
        } finally {
            assertNotEquals("Tacko", testList.getFirstName(0));
            assertNotEquals("Fall", testList.getLastName(0));
            assertNotEquals("555-555-5555", testList.getPhoneNumber(0));
            assertNotEquals("thetackofall@gmail.com", testList.getEmailAddress(0));
            assertEquals("", testList.getFirstName(0));
            assertEquals("Mathers", testList.getLastName(0));
            assertEquals("313-555-5555", testList.getPhoneNumber(0));
            assertEquals("slimshady@aftermath.com", testList.getEmailAddress(0));
        }
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        ContactList testList = new ContactList();
        try {
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testList.getContacts().add(testContact);
            testList.editContact(0, "Marshall" ,"", "313-555-5555", "slimshady@aftermath.com");
        } catch (Exception e) {
        } finally {
            assertNotEquals("Tacko", testList.getFirstName(0));
            assertNotEquals("Fall", testList.getLastName(0));
            assertNotEquals("555-555-5555", testList.getPhoneNumber(0));
            assertNotEquals("thetackofall@gmail.com", testList.getEmailAddress(0));
            assertEquals("Marshall", testList.getFirstName(0));
            assertEquals("", testList.getLastName(0));
            assertEquals("313-555-5555", testList.getPhoneNumber(0));
            assertEquals("slimshady@aftermath.com", testList.getEmailAddress(0));
        }
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        ContactList testList = new ContactList();
        try {
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testList.getContacts().add(testContact);
            testList.editContact(0, "Marshall" ,"Mathers", "", "slimshady@aftermath.com");
        } catch (Exception e) {
        } finally {
            assertNotEquals("Tacko", testList.getFirstName(0));
            assertNotEquals("Fall", testList.getLastName(0));
            assertNotEquals("555-555-5555", testList.getPhoneNumber(0));
            assertNotEquals("thetackofall@gmail.com", testList.getEmailAddress(0));
            assertEquals("Marshall", testList.getFirstName(0));
            assertEquals("Mathers", testList.getLastName(0));
            assertEquals("", testList.getPhoneNumber(0));
            assertEquals("slimshady@aftermath.com", testList.getEmailAddress(0));
        }
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        ContactList testList = new ContactList();
        try {
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testList.getContacts().add(testContact);
            testList.editContact(0, "" ,"", "", "");
        } catch (Exception e) {
            final String expectedMessage = "Unable to edit contact: All fields were left blank";
            assertEquals(expectedMessage, e.getMessage());
        }

    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        ContactList testList = new ContactList();
        try {
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testList.getContacts().add(testContact);
            testList.editContact(1, "Marshall" ,"Mathers", "", "slimshady@aftermath.com");
        } catch (IndexOutOfBoundsException e) {
            final String expectedMessage = "Unable to edit contact: Invalid index";
            assertEquals(expectedMessage, e.getMessage());
        } catch (Exception e){}
    }


    //Load Test
    @Test
    public void savedContactListCanBeLoaded(){
        ContactList tempList = new ContactList();
        try{
            tempList.loadList("testContact.txt");
            assertEquals("Tacko", tempList.getFirstName(0));
            assertEquals("Fall", tempList.getLastName(0));
            assertEquals("555-555-5555", tempList.getPhoneNumber(0));
            assertEquals("thetackofall@gmail.com", tempList.getEmailAddress(0));
        } catch (Exception e){}
    }

    @Test
    public void incompatibleListCannotBeLoaded() {
        ContactList tempList = new ContactList();
        try {
            tempList.loadList("testTask.txt");
        } catch (Exception e) {
            final String expectedMessage = "File is not a contact list";
            assertEquals(expectedMessage, e.getMessage());
        }
    }
}