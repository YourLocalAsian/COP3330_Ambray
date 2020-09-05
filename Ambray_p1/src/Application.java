//Application.java
//Main function that calls methods to encrypt and decrypt input string
import java.util.Scanner;

public class Application {
    public static void main(String [] args){
        //create a Scanner object to obtain input from the command window
        Scanner input = new Scanner(System.in);

        //prints prompt for user
        

        //while-loop
        String thing = "";
        while(!thing.equalsIgnoreCase("stop")) {


        }
        //creates an Encypter object
        //Encrypter myEncrypter = new Encrypter();

        //creates an Decypter object
        Decrypter myDecrypter = new Decrypter();

        System.out.printf("Please enter an integer string: ");
        String theInput = input.nextLine();
        myDecrypter.decrypt(theInput);

        System.out.println(); // outputs a blank line
    }
}
