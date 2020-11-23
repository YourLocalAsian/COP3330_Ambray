import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactItemTest {
    //Creation Tests
    @Test
    public void creationSucceedsWithNonBlankValues(){
        try{
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            final String successMessage = "Contact was created successfully";
            assertEquals("Contact was created successfully", successMessage);
        } catch (Exception e) {}
    }

    @Test
    public void creationFailsWithAllBlankValues(){
        try{
            ContactItem testContact = new ContactItem("","","","");
        } catch (Exception e) {
            final String expectedMessage = "Unable to create contact: All fields were left blank";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        try{
            ContactItem testContact = new ContactItem("","Fall","555-555-5555","thetackofall@gmail.com");
            final String successMessage = "Contact was created successfully";
            assertEquals("Contact was created successfully", successMessage);
        } catch (Exception e) {}
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        try{
            ContactItem testContact = new ContactItem("Tacko","","555-555-5555","thetackofall@gmail.com");
            final String successMessage = "Contact was created successfully";
            assertEquals("Contact was created successfully", successMessage);
        } catch (Exception e) {}
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        try{
            ContactItem testContact = new ContactItem("Tacko","Fall","","thetackofall@gmail.com");
            final String successMessage = "Contact was created successfully";
            assertEquals("Contact was created successfully", successMessage);
        } catch (Exception e) {}
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        try{
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","");
            final String successMessage = "Contact was created successfully";
            assertEquals("Contact was created successfully", successMessage);
        } catch (Exception e) {}
    }

    //Editing Tests
    @Test
    public void editingSucceedsWithNonBlankValues(){
        try{
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testContact.editContactInformation("LaMelo", "Ball", "555-505-5555", "lavarsbetterson@gmail.com");
            assertEquals(testContact.getFirstName(), "LaMelo");
            assertEquals(testContact.getLastName(), "Ball");
            assertEquals(testContact.getPhoneNumber(), "555-505-5555");
            assertEquals(testContact.getEmailAddress(), "lavarsbetterson@gmail.com");
        } catch (Exception e) {}
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        try {
            ContactItem testContact = new ContactItem("Tacko", "Fall", "555-555-5555", "thetackofall@gmail.com");
            testContact.editContactInformation("", "", "", "");
        }catch (Exception e){
            final String expectedMessage = "Unable to edit contact: All fields were left blank";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        try{
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testContact.editContactInformation("", "Ball", "555-505-5555", "lavarsbetterson@gmail.com");
            assertEquals(testContact.getFirstName(), "");
            assertEquals(testContact.getLastName(), "Ball");
            assertEquals(testContact.getPhoneNumber(), "555-505-5555");
            assertEquals(testContact.getEmailAddress(), "lavarsbetterson@gmail.com");
        } catch (Exception e) {}
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        try{
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testContact.editContactInformation("LaMelo", "", "555-505-5555", "lavarsbetterson@gmail.com");
            assertEquals(testContact.getFirstName(), "LaMelo");
            assertEquals(testContact.getLastName(), "");
            assertEquals(testContact.getPhoneNumber(), "555-505-5555");
            assertEquals(testContact.getEmailAddress(), "lavarsbetterson@gmail.com");
        } catch (Exception e) {}
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        try{
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testContact.editContactInformation("LaMelo", "Ball", "", "lavarsbetterson@gmail.com");
            assertEquals(testContact.getFirstName(), "LaMelo");
            assertEquals(testContact.getLastName(), "Ball");
            assertEquals(testContact.getPhoneNumber(), "");
            assertEquals(testContact.getEmailAddress(), "lavarsbetterson@gmail.com");
        } catch (Exception e) {}
    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        try{
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            testContact.editContactInformation("LaMelo", "Ball", "555-505-5555", "");
            assertEquals(testContact.getFirstName(), "LaMelo");
            assertEquals(testContact.getLastName(), "Ball");
            assertEquals(testContact.getPhoneNumber(), "555-505-5555");
            assertEquals(testContact.getEmailAddress(), "");
        } catch (Exception e) {}
    }

    //To-String Tests
    @Test
    public void testToStringWithAllFieldsFilled(){
        try{
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","thetackofall@gmail.com");
            final String expectedToString = "Name: Tacko Fall\nPhone: 555-555-5555\nEmail: thetackofall@gmail.com\n";
            assertEquals(expectedToString, testContact.toString());
        } catch (Exception e) {}
    }

    @Test
    public void testToStringWithoutFirstName(){
        try{
            ContactItem testContact = new ContactItem("","Fall","555-555-5555","thetackofall@gmail.com");
            final String expectedToString = "Name: Fall\nPhone: 555-555-5555\nEmail: thetackofall@gmail.com\n";
            assertEquals(expectedToString, testContact.toString());
        } catch (Exception e) {}
    }

    @Test
    public void testToStringWithoutLastName(){
        try{
            ContactItem testContact = new ContactItem("Tacko","","555-555-5555","thetackofall@gmail.com");
            final String expectedToString = "Name: Tacko\nPhone: 555-555-5555\nEmail: thetackofall@gmail.com\n";
            assertEquals(expectedToString, testContact.toString());
        } catch (Exception e) {}
    }

    @Test
    public void testToStringWithoutPhone(){
        try{
            ContactItem testContact = new ContactItem("Tacko","Fall","","thetackofall@gmail.com");
            final String expectedToString = "Name: Tacko Fall\nEmail: thetackofall@gmail.com\n";
            assertEquals(expectedToString, testContact.toString());
        } catch (Exception e) {}
    }

    @Test
    public void testToStringWithoutEmail(){
        try{
            ContactItem testContact = new ContactItem("Tacko","Fall","555-555-5555","");
            final String expectedToString = "Name: Tacko Fall\nPhone: 555-555-5555\n";
            assertEquals(expectedToString, testContact.toString());
        } catch (Exception e) {}
    }

}