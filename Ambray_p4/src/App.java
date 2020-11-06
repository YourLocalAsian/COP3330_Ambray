import java.sql.SQLOutput;
import java.util.Scanner;

public class App {
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args){

        //displayMainMenu();
        //System.out.println();
        TaskList myList = new TaskList();
        selectOperation(myList);

        //Open a list
            //try to open file for deserialization
                    //unmarshal the files contents
                    //display contents

        //Quit program
            //exit program
    }

    public static void displayMainMenu(){
        System.out.printf("Main Menu\n" +
                        "---------\n" +
                        "1) create a new list\n" +
                        "2) load an existing list\n" +
                        "3) quit\n\n");
    }

    public static void selectMainMenu(){
        while(true){
            int userChoice = userInput.nextInt();
            switch(userChoice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid operation. Select an option 1-3");
            }
        }
    }

    public static void displayListOperationMenu(){
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

    public static void selectOperation(TaskList myList){
        while(true){
            displayListOperationMenu();
            int userChoice = userInput.nextInt();
            switch(userChoice){
                case 1:
                    System.out.println("Current tasks\n" + "--------------");
                    viewList(myList);
                    break;
                case 2:
                    myList.addTaskItem();
                    break;
                case 3:
                    System.out.println("Current tasks\n" + "--------------");
                    viewList(myList);
                    System.out.printf("Which task will you edit? ");
                    myList.humanEditTaskItem();
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Incomplete tasks\n" + "--------------");
                    optionViewList(myList, 1);
                    System.out.printf("Which item would you like to mark as complete? ");
                    myList.humanCompleteTaskItem();
                    break;
                case 6:
                    System.out.println("Complete tasks\n" + "--------------");
                    optionViewList(myList, 2);
                    System.out.printf("Which item would you like to mark as incomplete? ");
                    myList.humanUncompleteTaskItem();
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid operation. Select an option 1-8");
            }
        }
    }

    public static void viewList(TaskList myList){
        for (int i = 0; i < myList.getTaskItems().size(); i++){
            if(myList.getTaskItems().get(i).getTaskCompletionStatus()){
               System.out.printf("*** ");
            }
            System.out.println(i + ") [" + myList.getTaskItems().get(i).getTaskDueDate() + "] " +
                    myList.getTaskItems().get(i).getTaskTitle() + ": " +
                    myList.getTaskItems().get(i).getTaskDescription());
        }
        System.out.println();
    }

    public static void optionViewList(TaskList myList, int option){
        switch(option){
            case 1: //incomplete
                for (int i = 0; i < myList.getTaskItems().size(); i++){
                    if(!myList.getTaskItems().get(i).getTaskCompletionStatus()){
                        System.out.println(i + ") [" + myList.getTaskItems().get(i).getTaskDueDate() + "] " +
                                myList.getTaskItems().get(i).getTaskTitle() + ": " +
                                myList.getTaskItems().get(i).getTaskDescription());
                    }
                }
                System.out.println();
                break;
            case 2: //complete
                for (int i = 0; i < myList.getTaskItems().size(); i++){
                    if(myList.getTaskItems().get(i).getTaskCompletionStatus()){
                        System.out.println(i + ") [" + myList.getTaskItems().get(i).getTaskDueDate() + "] " +
                                myList.getTaskItems().get(i).getTaskTitle() + ": " +
                                myList.getTaskItems().get(i).getTaskDescription());
                    }
                }
                System.out.println();
                break;
        }
    }

    public static void createNewList(){
        //Create the list
            //open a file write objects to it then close file
            //create buffered writer
            //store TaskItems in TaskList before XML serialization

            //write to TaskList's XML to output
    }
}
