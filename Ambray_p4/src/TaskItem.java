import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TaskItem {
    private String taskTitle;
    private String taskDescription;
    private LocalDate taskDueDate;
    private boolean taskCompletionStatus = false;

    public TaskItem(String taskTitle, String taskDescription, String strTaskDueDate) throws Exception {
        try {
            if(taskTitle.length() > 0) {
                this.taskTitle = taskTitle;
            } else {
              throw new Exception("Invalid title");
            }

            this.taskDescription = taskDescription;
            this.taskDueDate = LocalDate.parse(strTaskDueDate);

        } catch (DateTimeParseException dateTimeParseException){
            System.out.println();
            throw new Exception("Invalid date");
        }
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) throws Exception{
            if (taskTitle.length() > 0) {
                this.taskTitle = taskTitle;
            } else {
                throw new Exception("Invalid title");
            }
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

    public void setTaskDueDate(String strTaskDueDate) throws Exception{
        try {
            this.taskDueDate = LocalDate.parse(strTaskDueDate);
        } catch (DateTimeParseException dateTimeParseException){
            System.out.println();
            throw new Exception("Invalid date");
        }
    }


    public boolean getTaskCompletionStatus() {
        return taskCompletionStatus;
    }

    public void setTaskCompletionStatus(boolean taskCompletionStatus) {
        this.taskCompletionStatus = taskCompletionStatus;
    }


}
