import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    static final int FULL = 0;
    static final int INCOMPLETE = 1;
    static final int COMPLETE = 2;

    static final int CREATE = 0;
    static final int LOAD = 1;
    static final int QUIT = 2;

    static int completeCounter = 0;
    static int incompleteCounter = 0;

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args){
        runMainMenu();
    }

    private static void runMainMenu(){
        displayMainMenu();
        selectMainMenu();
    }

    private static void displayMainMenu(){
        System.out.printf("Main Menu\n" +
                        "---------\n" +
                        "1) create a new list\n" +
                        "2) load an existing list\n" +
                        "3) quit\n\n");
    }

    private static void selectMainMenu(){
        while(true){
            int userChoice = userInput.nextInt();
            switch(userChoice){
                case CREATE:
                    TaskList myList = new TaskList();
                    selectOperation(myList);
                    break;
                case LOAD:
                    TaskList tempList = new TaskList();
                    System.out.print("Select the file you want to open (add .txt file extension): ");
                    tempList.humanLoadList();
                    System.out.println();
                    selectOperation(tempList);
                case QUIT:
                    System.exit(1);
                default:
                    System.out.println("Invalid operation. Select an option 1-3");
                    break;
            }
        }
    }

    private static void displayListOperationMenu(){
        System.out.printf("List Operation Menu\n" +
                "--------------------\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) mark an item as completed\n" +
                "6) unmark an item as completed\n" +
                "7) save the current list\n" +
                "8) quit to the main menu\n\n");
    }

    private static void selectOperation(TaskList myList){
        boolean continueOperation = true;
        while(continueOperation){
            displayListOperationMenu();
            int userChoice = userInput.nextInt();
            switch(userChoice){
                case 1:
                    System.out.println("Current tasks\n" + "--------------");
                    optionViewList(myList, FULL);
                    break;
                case 2:
                    myList.addTaskItem();
                    break;
                case 3:
                    System.out.println("Current tasks\n" + "--------------");
                    optionViewList(myList, FULL);
                    System.out.printf("Which task will you edit? ");
                    myList.humanEditTaskItem();
                    break;
                case 4:
                    System.out.println("Current tasks\n" + "--------------");
                    optionViewList(myList, FULL);
                    System.out.printf("Which task will you delete? ");
                    myList.humanRemoveTaskItem();
                    break;
                case 5:
                    System.out.println("Incomplete tasks\n" + "--------------");
                    optionViewList(myList, INCOMPLETE);
                    if(incompleteCounter != 0) {
                        System.out.printf("Which item would you like to mark as complete? ");
                        myList.humanCompleteTaskItem();
                        System.out.println();
                    } else {
                        System.out.println("No tasks are incomplete\n");
                    }
                    break;
                case 6:
                    System.out.println("Complete tasks\n" + "--------------");
                     optionViewList(myList, COMPLETE);
                    if(incompleteCounter != 0) {
                        System.out.printf("Which item would you like to mark as incomplete? ");
                        myList.humanUncompleteTaskItem();
                        System.out.println();
                    } else {
                        System.out.println("No tasks are complete\n");
                    }
                    break;
                case 7:
                    System.out.printf("What would you like save for list as? (add .txt file extension) ");
                    myList.saveTaskList();
                    break;
                case 8:
                    continueOperation = false;
                    break;
                default:
                    System.out.println("Invalid operation. Select an option 1-8");
            }
        }
        runMainMenu();
        System.out.println();
    }

    private static void optionViewList(TaskList myList, int option){
        switch(option){
            case FULL:
                if(myList.getTaskItems().size() == 0){
                    System.out.println("No tasks in list\n");
                } else {
                    for (int i = 0; i < myList.getTaskItems().size(); i++) {
                        if(myList.getCompletionStatus(i)){
                            System.out.printf("[***] ");
                        }
                        System.out.println(i + ") [" + myList.getTaskDueDate(i) + "] " +
                                myList.getTaskTitle(i) + ": " +
                                myList.getTaskDescription(i));
                    }
                    System.out.println();
                }
                break;
            case COMPLETE: //complete
                for (int i = 0; i < myList.getTaskItems().size(); i++){
                    if(myList.getCompletionStatus(i)) {
                        System.out.println(i + ") [" + myList.getTaskDueDate(i) + "] " +
                                myList.getTaskTitle(i) + ": " +
                                myList.getTaskDescription(i));
                        completeCounter++;
                    }
                }
                System.out.println();
                break;
            case INCOMPLETE: //complete
                for (int i = 0; i < myList.getTaskItems().size(); i++){
                    if(!myList.getCompletionStatus(i)){
                        System.out.println(i + ") [" + myList.getTaskDueDate(i) + "] " +
                                myList.getTaskTitle(i) + ": " +
                                myList.getTaskDescription(i));
                        incompleteCounter++;
                    }
                }
                System.out.println();
                break;
        }
    }

}
