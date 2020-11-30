import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class ContactList extends ParentList{
    private ArrayList<ContactItem> contacts = new ArrayList<>(); // stores Accounts

    public List<ContactItem> getContacts() {
        return contacts;
    }

    public void addItem() {
        while (true) {
            String firstName = "";
            String lastName = "";
            String phoneNumber = "";
            String emailAddress = "";

            System.out.print("First name: ");
            firstName = scnr.nextLine();

            System.out.print("Last name: ");
            lastName = scnr.nextLine();

            System.out.print("Phone number: ");
            phoneNumber = scnr.nextLine();

            System.out.print("Email: ");
            emailAddress = scnr.nextLine();

            try{
                ContactItem contact = new ContactItem(firstName, lastName, phoneNumber, emailAddress);
                getContacts().add(contact);
                System.out.println();
                break;
            } catch (Exception e) {
                System.out.println("Unable to create contact: All fields were left blank\n");
            }
        }
    }

    public int askForElementIndex() throws IndexOutOfBoundsException{
        int userInput = scnr.nextInt();
        if (userInput > (getContacts().size() -1 ) || getContacts().size() == 0) {
            return -1;
        } else {
            return userInput;
        }
    }

    public void humanEditContact(){
        int userIndex = askForElementIndex();
        if (userIndex == -1){
            System.out.println("Selected item does not exist\n"); // do nothing
        } else {
            boolean pendingEdit = true;
            while (pendingEdit) {
                try {
                    scnr.nextLine();

                    String firstName = "";
                    String lastName = "";
                    String phoneNumber = "";
                    String emailAddress = "";

                    System.out.print("Enter a new first name: ");
                    firstName = scnr.nextLine();

                    System.out.print("Enter a new last name: ");
                    lastName = scnr.nextLine();

                    System.out.print("Enter a new phone number: ");
                    phoneNumber = scnr.nextLine();

                    System.out.print("Enter a new email address: ");
                    emailAddress = scnr.nextLine();

                    editContact(userIndex, firstName, lastName, phoneNumber, emailAddress);
                    System.out.println();
                    pendingEdit = false;
                } catch (IndexOutOfBoundsException indexOutOfBoundsException){
                    System.out.println("Unable to edit contact: Invalid index");
                } catch (Exception e){}
                }
            }
    }

    public void editContact(int userIndex, String firstName, String lastName, String phoneNumber, String emailAddress) throws Exception {
        try {
            getContacts().get(userIndex).editContactInformation(firstName, lastName, phoneNumber, emailAddress);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new IndexOutOfBoundsException("Unable to edit contact: Invalid index");
        } catch (Exception e) {
            System.out.println("Unable to edit contact: All fields were left blank");
            throw new Exception("Unable to edit contact: All fields were left blank");
        }
    }

    public void humanRemoveItem() {
        int userIndex = askForElementIndex();
        if (userIndex == -1) {
            System.out.println("Selected item does not exist\n"); // do nothing
        } else {
            removeItem(userIndex);
        }
    }

    public void removeItem(int contactNumber) {
        boolean indexIsInvalid = true;
        while (indexIsInvalid) {
            try {
                getContacts().remove(contactNumber);
                System.out.println("Contact #" + contactNumber + " has been deleted\n");
                indexIsInvalid = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IndexOutOfBoundsException("Unable to remove item: Invalid index");
            }
        }
    }

    public String getFirstName(int contactNumber) throws IndexOutOfBoundsException {
        boolean indexIsInvalid = true;
        String requestedFirstName= "";
        while (indexIsInvalid) {
            try {
                requestedFirstName = getContacts().get(contactNumber).getFirstName();
                indexIsInvalid = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IndexOutOfBoundsException("Unable to get first name: Invalid index");
            }
        }
        return requestedFirstName;
    }

    public String getLastName(int contactNumber) throws IndexOutOfBoundsException {
        boolean indexIsInvalid = true;
        String requestedLastName= "";
        while (indexIsInvalid) {
            try {
                requestedLastName = getContacts().get(contactNumber).getLastName();
                indexIsInvalid = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IndexOutOfBoundsException("Unable to get last name: Invalid index");
            }
        }
        return requestedLastName;
    }

    public String getPhoneNumber(int contactNumber) throws IndexOutOfBoundsException {
        boolean indexIsInvalid = true;
        String requestedPhoneNumber = "";
        while (indexIsInvalid) {
            try {
                requestedPhoneNumber = getContacts().get(contactNumber).getPhoneNumber();
                indexIsInvalid = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IndexOutOfBoundsException("Unable to get phone number: Invalid index");
            }
        }
        return requestedPhoneNumber;
    }

    public String getEmailAddress(int contactNumber) throws IndexOutOfBoundsException {
        boolean indexIsInvalid = true;
        String requestedEmailAddress = "";
        while (indexIsInvalid) {
            try {
                requestedEmailAddress = getContacts().get(contactNumber).getEmailAddress();
                indexIsInvalid = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IndexOutOfBoundsException("Unable to get email address: Invalid index");
            }
        }
        return requestedEmailAddress;
    }

    public void saveList() {
        String userExport = askForInputString();
        boolean pendingSave = true;
        while(pendingSave){
            if (getContacts().size() == 0){
                System.out.println("This list is empty\n");
                break;
            } else {
                try (Formatter output = new Formatter("src/" +userExport)) {
                    output.format("type=Contact\n\n");
                    for (int i = 0; i < getContacts().size(); i++) {
                        output.format("%s\n%s\n%s\n%s\n", getFirstName(i),
                                getLastName(i), getPhoneNumber(i), getEmailAddress(i));
                        output.format("\n");
                    }
                    output.format("01000101 01001111 01000110");
                    break;
                } catch (SecurityException | FileNotFoundException | FormatterClosedException | NoSuchElementException e) {
                    File myFile = new File(userExport);
                } finally {
                    pendingSave = false;;
                    System.out.println();
                }
            }
        }
    }

    public void humanLoadList(){
        boolean pendingLoad = true;
        while(pendingLoad) {
            try {
                String userInput = askForInputString();
                loadList(userInput);
            } catch (Exception e ){
                break;
            } finally {
                pendingLoad = false;
            }
        }
    }

    public void loadList(String userImport) throws Exception {
        String endLoad = "";
        boolean moreInformation = true;
        try (Scanner input = new Scanner(Paths.get("src/" + userImport))) {
            String fileType = input.nextLine();
            if (fileType.equals("type=Contact")) {
                input.nextLine();
                endLoad = input.nextLine();
                while (moreInformation) {
                    if (!endLoad.equals("01000101 01001111 01000110")) {
                        ContactItem newContact = new ContactItem(endLoad, input.nextLine(), input.nextLine(),
                                input.nextLine());
                        getContacts().add(newContact);
                        input.nextLine();
                        endLoad = input.nextLine();
                    } else if(endLoad.equals("01000101 01001111 01000110")){
                        moreInformation = false;
                    }
                }
            } else throw new IncorrectFileTypeException("Incompatible file type");
        } catch (NoSuchElementException | IllegalStateException e) {
        } catch (IOException e) {
            System.out.println("File does not exist. A new list has been made for you.");
        } catch (IncorrectFileTypeException incorrectFileTypeException){
            System.out.println("Unable to open file: Not a Contact List\nA new list has been made for you.");
            throw new Exception("File is not a contact list");
        } catch (Exception e){
            System.out.println("Unable to open file: File may be corrupted");
        }
    }

}

