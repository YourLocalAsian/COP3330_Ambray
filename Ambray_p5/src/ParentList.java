import java.util.Scanner;

public abstract class ParentList {
    protected static Scanner scnr = new Scanner(System.in);

    protected static String askForInputString(){
        String userInput = scnr.nextLine();
        return userInput;
    }

    protected abstract void addItem();

    protected abstract void humanRemoveItem();

    protected abstract void removeItem(int itemNumber);

    protected abstract void saveList();

    protected abstract void humanLoadList();

    protected abstract void loadList(String userInput) throws Exception;
}
