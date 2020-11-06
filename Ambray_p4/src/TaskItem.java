import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskItem {
    private String taskTitle;
    private String taskDescription;
    private LocalDate taskDueDate;
    private boolean taskCompletionStatus = false;

    public TaskItem(String taskTitle, String taskDescription, String strTaskDueDate) throws Exception {
        try {
            this.taskTitle = taskTitle;
            this.taskDescription = taskDescription;
            this.taskDueDate = LocalDate.parse(strTaskDueDate);
        } catch (DateTimeParseException dateTimeParseException){
            System.out.println();
            throw new Exception();
        }
    }

    public static boolean checkValidName(String name) {
        if (name.length() > 0) {
            return true;
        } else return false;
    }


    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getTaskDueDate() {
        return taskDueDate;
    }


    public boolean isTaskCompletionStatus() {
        return taskCompletionStatus;
    }

    public void setTaskCompletionStatus(boolean taskCompletionStatus) {
        this.taskCompletionStatus = taskCompletionStatus;
    }

}
