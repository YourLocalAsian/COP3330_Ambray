import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class TaskList {
    private static Scanner scnr = new Scanner(System.in);

    private ArrayList<TaskItem> taskItems = new ArrayList<>(); // stores Accounts

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

    private static String askForInputString(){
        String userInput = scnr.nextLine();
        return userInput;
    }

    public int askForElementIndex() throws IndexOutOfBoundsException{
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
                System.out.println("The selected item does not exist");
                break;
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
                System.out.println("The selected item does not exist");
                break;
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
                throw new Exception("Unable to mark item as complete: Invalid index");
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
                throw new Exception("Unable to mark item as incomplete: Invalid index");
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
                humanEditTaskItemTitle(userIndex);

                System.out.printf("Enter a new description for task " + userIndex + ": ");
                humanEditTaskItemDescription(userIndex);

                System.out.printf("Enter a new due date (YYYY-MM-DD) for task " + userIndex + ": ");
                humanEditTaskItemDueDate(userIndex);

                System.out.println();
                pendingEdit = false;
            }
        }
    }

    public void humanEditTaskItemTitle(int ElementIndex) {
        boolean pendingTitleChange = true;
        while(pendingTitleChange) {
            try {
                scnr.nextLine();
                String userInput = askForInputString();
                editTaskItemTitle(ElementIndex, userInput);
                pendingTitleChange = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                System.out.println("Selected item does not exist");
            } catch (Exception e) {
                System.out.println("Invalid name: Name must be longer than 1 character");
                System.out.printf("Enter a new title for task " + ElementIndex + ": ");
            }
        }
    }

    public void editTaskItemTitle(int taskNumber, String userInput) throws Exception, IndexOutOfBoundsException{
        boolean nameIsInvalid = true;
        while (nameIsInvalid) {
            try {
                getTaskItems().get(taskNumber).setTaskTitle(userInput);
                nameIsInvalid = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IndexOutOfBoundsException("Unable to edit name: Invalid index");
            } catch (Exception e) {
                throw new Exception("Unable to edit name: Invalid name");
            }
        }
    }

    public void humanEditTaskItemDescription(int ElementIndex){
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
            throw new Exception("Unable to edit description: Invalid index");
        }
    }

    public void humanEditTaskItemDueDate(int ElementIndex){
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
                throw new IndexOutOfBoundsException("Unable to edit date: Invalid index");
            } catch (Exception e) {
                throw new Exception("Unable to edit date: Invalid date");
            }
        }
    }

    public void humanRemoveTaskItem() {
        int userIndex = askForElementIndex();
        if (userIndex == -1) {
            System.out.println("Selected item does not exist\n"); // do nothing
        } else {
            removeTaskItem(userIndex);
        }
    }

    public void removeTaskItem(int taskNumber) {
        boolean indexIsInvalid = true;
        while (indexIsInvalid) {
            try {
                System.out.println(getTaskTitle(taskNumber) + " has been deleted\n");
                getTaskItems().remove(taskNumber);
                indexIsInvalid = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IndexOutOfBoundsException("Unable to remove item: Invalid index");
            }
        }
    }

    public String getTaskTitle(int taskNumber) throws IndexOutOfBoundsException {
        boolean indexIsInvalid = true;
        String requestedTaskTitle = "";
        while (indexIsInvalid) {
            try {
                requestedTaskTitle = getTaskItems().get(taskNumber).getTaskTitle();
                indexIsInvalid = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IndexOutOfBoundsException("Unable to get title: Invalid index");
            }
        }
        return requestedTaskTitle;
    }

    public String getTaskDescription(int taskNumber) {
        boolean indexIsInvalid = true;
        String requestedTaskDescription = "";
        while (indexIsInvalid) {
            try {
                requestedTaskDescription = getTaskItems().get(taskNumber).getTaskDescription();
                indexIsInvalid = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IndexOutOfBoundsException("Unable to get description: Invalid index");
            }
        }
        return requestedTaskDescription;
    }

    public LocalDate getTaskDueDate(int taskNumber) {
        boolean indexIsInvalid = true;
        LocalDate requestedTaskDueDate = LocalDate.parse("1900-01-01");
        while (indexIsInvalid) {
            try {
                requestedTaskDueDate = getTaskItems().get(taskNumber).getTaskDueDate();
                indexIsInvalid = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                throw new IndexOutOfBoundsException("Unable to get date: Invalid index");
            }
        }
        return requestedTaskDueDate;
    }

    public boolean getCompletionStatus(int taskNumber){
        boolean indexIsInvalid = true;
        boolean requestedCompletionStatus = false;
        while (indexIsInvalid) {
            try {
                requestedCompletionStatus = getTaskItems().get(taskNumber).getTaskCompletionStatus();
                indexIsInvalid = false;
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                System.out.println("The selected item does not exist");
                return false;
            }
        }
        return requestedCompletionStatus;
    }

    public void saveTaskList() {
        String userExport = askForInputString();
        boolean pendingSave = true;
        while(pendingSave){
            if (getTaskItems().size() == 0){
                System.out.println("This list is empty\n");
                break;
            } else {
                try (Formatter output = new Formatter(userExport)) {
                    for (int i = 0; i < getTaskItems().size(); i++) {
                        output.format("%s\n%s\n%s\n%s\n", getTaskTitle(i),
                                getTaskDescription(i), getTaskDueDate(i).toString(), getCompletionStatus(i));
                        output.format("\n");
                    }
                    output.format("-1");
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
                loadTaskList(userInput);
                pendingLoad = false;
            } catch (Exception e) {
                System.out.println("File does not exist");
            }
        }
    }

    public void loadTaskList(String userImport){
        try (Scanner input = new Scanner(Paths.get(userImport))) {
            String endLoad = "";
            while(!endLoad.equals("-1")) {
                endLoad = input.nextLine();
                TaskItem newTask = new TaskItem(endLoad, input.nextLine(), input.nextLine());
                newTask.setTaskCompletionStatus(Boolean.valueOf(input.nextLine()));
                getTaskItems().add(newTask);
                input.nextLine();
            }
        } catch (IOException | NoSuchElementException |
                IllegalStateException e) {
            System.out.println("File does not exist. A new list has been created for you.");
        } catch (Exception e){
            System.out.println("Invalid entry");
        }
    }
}




