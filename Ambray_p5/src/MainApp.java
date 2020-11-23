import java.util.Scanner;

public class MainApp {
    private static final int TASKLIST = 1;
    private static final int CONTACTLIST = 2;
    private static final int QUIT = 3;

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args){
        runAppMainMenu();
    }

    public static void runAppMainMenu() {
        displayAppMainMenu();
        selectAppMainMenu();
    }

    private static void displayAppMainMenu(){
        System.out.printf("Select Your Application\n" +
                "-----------------------\n" +
                "1) task list\n" +
                "2) contact list\n" +
                "3) quit\n\n");
    }

    private static void selectAppMainMenu(){
        boolean continueOperation = true;
        while(continueOperation){
            int userChoice = userInput.nextInt();
            switch(userChoice){
                case TASKLIST:
                    TaskApp.taskMain();
                    break;
                case CONTACTLIST:
                    ContactApp.contactMain();
                    break;
                case QUIT:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid operation. Select an option 1-3");
                    break;
            }
        }
    }

}
