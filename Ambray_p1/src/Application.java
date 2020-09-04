//Application.java
//Main function calls methods to encrypt and decrypt input string
import java.util.Scanner

public class Application {
    public static void main(String[] args){
        // create a Scanner object to obtain input from the command window
        Scanner input = new Scanner(System.in);

        //creates an Encrypter object
        Encrypter myEncrypter = new Encrypter();

        //choose to encrypt or decrypt
        String theInput = input.nextLine();
        myEncrypter.encrypt(theInput);
    }
}
