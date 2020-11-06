import java.sql.SQLOutput;

public class App {
    public static void main(String [] args){
        //displayMainMenu();
        //displayListOperationMenu();
        //System.out.println();
        TaskList myList = new TaskList();
        myList.addTaskItem();
        System.out.println(myList.getTaskItems().size());

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

    public static void displayListOperationMenu(){
        System.out.printf("List Operation Menu\n" +
                "---------\n" +
                "1) view the list\n" +
                "2) add an item\n" +
                "3) edit an item\n" +
                "4) remove an item\n" +
                "5) mark an item as completed\n" +
                "6) unmark an item as completed\n" +
                "7) save the current list\n" +
                "8) quit to the main menu");
    }

    public static void createNewList(){
        //Create the list
            //open a file write objects to it then close file
            //create buffered writer
            //store TaskItems in TaskList before XML serialization

            //write to TaskList's XML to output
    }
}
