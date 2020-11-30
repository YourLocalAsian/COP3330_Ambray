import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp{
    private static final int TASKLIST = 1;
    private static final int CONTACTLIST = 2;
    private static final int QUIT = 3;

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args){ runMainMenu(); }

    public static void runMainMenu() {
        displayMainMenu();
        selectMainMenu();
    }

    private static void displayMainMenu(){
        System.out.printf("Select Your Application\n" +
                "-----------------------\n" +
                "1) task list\n" +
                "2) contact list\n" +
                "3) quit\n\n");
    }

    private static void selectMainMenu(){
        boolean continueOperation = true;
        while(continueOperation){
            try {
            int userChoice = userInput.nextInt();
                switch (userChoice) {
                    case TASKLIST:
                        TaskApp taskApp = new TaskApp();
                        taskApp.taskMain();
                        break;
                    case CONTACTLIST:
                        ContactApp contactApp = new ContactApp();
                        contactApp.contactMain();
                        break;
                    case QUIT:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid operation. Select an option 1-3");
                        break;
                }
            } catch (InputMismatchException inputMismatchException){
                System.out.println("Invalid operation. Select an option 1-3");
                userInput.nextLine();
            }
        }
    }

}

class IncorrectFileTypeException extends Exception{
    public IncorrectFileTypeException(String errorMessage){
        super(errorMessage);
    }
}