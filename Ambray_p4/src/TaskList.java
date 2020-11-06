import javax.lang.model.element.Element;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskList {
    private ArrayList<TaskItem> taskItems = new ArrayList<>(); // stores Accounts

    private static Scanner scnr = new Scanner(System.in);
    // returns the List<Accounts>
    public List<TaskItem> getTaskItems() {
        return taskItems;
    }

    public void addTaskItem() {
        while (true) {
            boolean nameIsInvalid = true;
            boolean dateIsInvalid = true;
            String taskTitle = "";
            String taskDueDate = "";

            while (nameIsInvalid) {
                try {
                    System.out.print("Task title: ");
                    taskTitle = scnr.nextLine();

                    nameIsInvalid = false;
                } catch (Exception e) {
                    System.out.println("Invalid name: Name must be longer than 1 character");
                }
            }

            System.out.print("Task description: ");
            String taskDescription = scnr.nextLine();

            while (dateIsInvalid) {
                try {
                    System.out.print("Task due date (YYYY-MM-DD): ");
                    taskDueDate = scnr.nextLine();

                    TaskItem taskItem = new TaskItem(taskTitle, taskDescription, taskDueDate);
                    getTaskItems().add(taskItem);

                    System.out.println();
                    dateIsInvalid = false;
                } catch (Exception e) {
                    System.out.println("Invalid date, enter in YYYY-MM-DD format");
                }
            }

            break;
        }
    }

    private String askForInputString(){
        String userInput = scnr.nextLine();
        return userInput;
    }

    private int askForElementIndex() throws IndexOutOfBoundsException{
        boolean inputIndex = true;
        int userInput = scnr.nextInt();
        if (userInput > (getTaskItems().size() -1 ) || getTaskItems().size() == 0) {
            return -1;
        } else {
            return userInput;
        }
    }

    public void humanCompleteTaskItem(){
        boolean humanOperationPending = true;
        while(humanOperationPending) {
            try {
                int userInput = askForElementIndex();
                completeTaskItem(userInput);
                humanOperationPending = false;
            } catch (Exception e) {
                scnr.nextLine();
                System.out.println("Invalid index");
                System.out.println();
            }
        }
    }

    public void humanUncompleteTaskItem(){
        boolean humanOperationPending = true;
        while(humanOperationPending) {
            try {
                int userInput = askForElementIndex();
                uncompleteTaskItem(userInput);
                humanOperationPending = false;
            } catch (Exception e) {
                scnr.nextLine();
                System.out.println("Invalid index");
                System.out.println();
            }
        }
    }

    public void completeTaskItem(int ElementIndex) throws Exception {
        boolean pendingCompleteStatus = true;
        while(pendingCompleteStatus){
            try {
                getTaskItems().get(ElementIndex).setTaskCompletionStatus(true);
                pendingCompleteStatus = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new Exception("Invalid index");
            }
        }
    }

    public void uncompleteTaskItem(int ElementIndex) throws Exception {
        boolean pendingUncompleteStatus = true;
        while(pendingUncompleteStatus){
            try {
                getTaskItems().get(ElementIndex).setTaskCompletionStatus(false);
                pendingUncompleteStatus = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new Exception("Invalid index");
            }
        }
    }

    public void humanEditTaskItem(){
        int userIndex = askForElementIndex();
        if (userIndex == -1){
            System.out.println("Selected item does not exist\n"); // do nothing
        } else {
            boolean pendingEdit = true;
            while (pendingEdit) {
                System.out.printf("Enter a new title for task " + userIndex + ": ");
                humanEditTaskItemName(userIndex);

                System.out.printf("Enter a new description for task " + userIndex + ": ");
                humanEditTaskItemDescription(userIndex);

                System.out.printf("Enter a new due date (YYYY-MM-DD) for task " + userIndex + ": ");
                humanEditTaskItemDueDate(userIndex);

                System.out.println();
                pendingEdit = false;
            }
        }
    }

    private void humanEditTaskItemName(int ElementIndex) {
        boolean pendingTitleChange = true;
        while(pendingTitleChange) {
            try {
                String userInput = askForInputString();
                editTaskItemName(ElementIndex, userInput);
                pendingTitleChange = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                System.out.println("Selected item does not exist");
            } catch (Exception e) {
                System.out.println("Invalid name: Name must be longer than 1 character");
                System.out.printf("Enter a new title for task " + ElementIndex + ": ");
            }
        }
    }

    public void editTaskItemName(int taskNumber, String userInput) throws Exception, IndexOutOfBoundsException{
        boolean nameIsInvalid = true;
        while (nameIsInvalid) {
            try {
                String inputTaskTitle = scnr.nextLine();
                getTaskItems().get(taskNumber).setTaskTitle(inputTaskTitle);
                nameIsInvalid = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IndexOutOfBoundsException();
            } catch (Exception e) {
                throw new Exception("Invalid name");
            }
        }
    }

    private void humanEditTaskItemDescription(int ElementIndex){
        boolean pendingDescriptionChange = true;
        while(pendingDescriptionChange) {
            try {
                String userInput = askForInputString();
                editTaskItemDescription(ElementIndex ,userInput);
                pendingDescriptionChange = false;
            } catch (Exception e) {
                System.out.println("Invalid index: Selected element does not exist");
            }
        }
    }

    public void editTaskItemDescription(int taskNumber, String userInput) throws Exception{
        try {
            getTaskItems().get(taskNumber).setTaskDescription(userInput);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw new Exception("Invalid index");
        }
    }

    private void humanEditTaskItemDueDate(int ElementIndex){
        boolean pendingDueDateChange = true;
        while(pendingDueDateChange) {
            try {
                String userInput = askForInputString();
                editTaskItemDueDate(ElementIndex ,userInput);
                pendingDueDateChange = false;
            } catch (Exception e) {
                System.out.println("Invalid date, enter in YYYY-MM-DD format");
                System.out.printf("Enter a new due date for task " + ElementIndex + ": ");
            }
        }
    }

    public void editTaskItemDueDate(int taskNumber, String userInput) throws Exception{
        boolean dateIsInvalid = true;
        while (dateIsInvalid) {
            try {
                getTaskItems().get(taskNumber).setTaskDueDate(userInput);
                dateIsInvalid = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException){
                throw new Exception("Invalid index");
            } catch (Exception e) {
                throw new Exception("Invalid date");
            }
        }
    }

    public void getTaskTitle(int taskNumber) {
    }

    public void getTaskDescription(int taskNumber) {
    }

    public void getTaskDueDate(int taskNumber) {
    }

    public void removeTaskItem(int taskNumber) {
    }

    public void saveTaskList() {
    }


}




