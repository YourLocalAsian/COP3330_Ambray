import java.util.Scanner;

public abstract class ParentApp <T extends ParentList>{
    protected final int FULL = 0;
    protected final int INCOMPLETE = 1;
    protected final int COMPLETE = 2;

    protected final int CREATE = 1;
    protected final int LOAD = 2;
    protected final int QUIT = 3;

    protected Scanner userInput = new Scanner(System.in);

    protected void runMainMenu(){
        displayMainMenu();
        selectMainMenu();
    };

    protected abstract void displayMainMenu();

    protected abstract void selectMainMenu();

    protected abstract void displayListOperationMenu();
}
