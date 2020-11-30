import java.util.InputMismatchException;

public class ContactApp extends ParentApp {

    public void contactMain(){
        runMainMenu();
    }

    protected void displayMainMenu(){
        System.out.printf("Contact App Main Menu\n" +
                "------------------\n" +
                "1) create a new list\n" +
                "2) load an existing list\n" +
                "3) quit\n\n");
    }

    protected void selectMainMenu(){
        boolean continueOperation = true;
        while(continueOperation){
            int userChoice = userInput.nextInt();
            switch(userChoice){
                case CREATE:
                    ContactList myList = new ContactList();
                    selectOperation(myList);
                    break;
                case LOAD:
                    ContactList tempList = new ContactList();
                    System.out.print("Select the file you want to open (add .txt file extension): ");
                    tempList.humanLoadList();
                    System.out.println();
                    selectOperation(tempList);
                case QUIT:
                    continueOperation = false;
                    break;
                default:
                    System.out.println("Invalid operation. Select an option 1-3");
                    break;
            }
        }
        MainApp.runMainMenu();
    }

    protected void displayListOperationMenu(){
        System.out.printf("List Operation Menu\n" +
                "--------------------\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit a contact\n" +
                "4) remove a contact\n" +
                "5) save the current list\n" +
                "6) quit to the main menu\n\n");
    }

    private void selectOperation(ContactList myList){
        boolean continueOperation = true;
        while(continueOperation){
            displayListOperationMenu();
            try {
                int userChoice = userInput.nextInt();
                switch (userChoice) {
                    case 1:
                        System.out.println("Current contacts\n" + "--------------");
                        optionViewList(myList);
                        break;
                    case 2:
                        myList.addItem();
                        break;
                    case 3:
                        System.out.println("Current contacts\n" + "--------------");
                        optionViewList(myList);
                        System.out.printf("Which contact will you edit? ");
                        myList.humanEditContact();
                        break;
                    case 4:
                        System.out.println("Current contacts\n" + "--------------");
                        optionViewList(myList);
                        System.out.printf("Which contact will you delete? ");
                        myList.humanRemoveItem();
                        break;
                    case 5:
                        System.out.printf("What would you like save for list as? (add .txt file extension) ");
                        myList.saveList();
                        break;
                    case 6:
                        continueOperation = false;
                        break;
                    default:
                        System.out.println("Invalid operation. Select an option 1-6");
                }
            } catch (InputMismatchException inputMismatchException){
                System.out.println("Invalid operation. Select an option 1-6");
                userInput.nextLine();
            }
        }
        runMainMenu();
        System.out.println();
    }

    private void optionViewList(ContactList myList){
        if(myList.getContacts().size() == 0){
            System.out.println("No contacts in list\n");
        } else {
            for (int i = 0; i < myList.getContacts().size(); i++) {
                System.out.printf("Contact #%d\n", i);
                System.out.println(myList.getContacts().get(i));
            }
            System.out.println();
                }

        }
}
