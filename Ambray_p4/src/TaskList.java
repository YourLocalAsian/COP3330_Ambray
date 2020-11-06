import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TaskList {
    private int taskNumber = 0;
    private static Scanner scnr = new Scanner(System.in);

    //@XmlElement(name="account")
    private ArrayList<TaskItem> taskItems = new ArrayList<>(); // stores Accounts

    // returns the List<Accounts>
    public ArrayList<TaskItem> getTaskItems() {
        return taskItems;
    }

    public void addTaskItem(){
        while(true){
                boolean nameIsInvalid = true;
                String taskTitle = "";
                String taskDueDate = "";

                while(nameIsInvalid) {
                    System.out.print("Task title: ");
                    taskTitle = scnr.nextLine();

                    if(taskTitle.length() > 0 ){
                        nameIsInvalid = false;
                    } else {
                        System.out.println("Invalid name: Name must be longer than 1 character");
                    }
                }

                System.out.print("Task description: ");
                String taskDescription = scnr.nextLine();

                while(true) {
                    try {
                        System.out.print("Task due date (YYYY-MM-DD): ");
                        taskDueDate = scnr.nextLine();

                        TaskItem taskItem = new TaskItem(taskTitle, taskDescription, taskDueDate);
                        getTaskItems().add(taskItem);
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid date, enter in YYYY-MM-DD format");
                    }
                }

                break;
                }
            }

            //create new TaskItem
        //add to TaskList



    public void completeTaskItem(int taskNumber){}

    public void uncompleteTaskItem(int taskNumber){}

    public void editTaskItemName(int taskNumber){}

    public void editTaskItemDescription(int taskNumber){}

    public void editTaskItemDueDate(int taskNumber){}

    public void getTaskTitle(int taskNumber){}

    public void getTaskDescription(int taskNumber){}

    public void getTaskDueDate(int taskNumber){}

    public void removeTaskItem(int taskNumber){}

    public void saveTaskList(){}



}
