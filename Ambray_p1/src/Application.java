//Application.java
//Main function that calls methods to encrypt and decrypt input string
import java.util.Scanner;

public class Application {
    public static void main(String [] args){
        //create a Scanner object to obtain input from the command window
        Scanner input = new Scanner(System.in);

        //prints prompt for user
        System.out.println("1 - Encrypt");
        System.out.println("2 - Decrypt");
        System.out.println("STOP - End program");

        //while-loop
        String thing = "";
        while(!thing.equalsIgnoreCase("stop")) {
            System.out.printf("\nPlease select an operation: ");
            thing = input.nextLine();
            System.out.println();

            if(thing.equals("1")){
                //creates an Encrypter object
                System.out.println("You selected: Encryption");
                Encrypter myEncrypter = new Encrypter();

                //prompts input
                System.out.printf("Please enter an integer string: ");
                String theInput = input.nextLine();
                String encryptedValue = myEncrypter.encrypt(theInput);
                System.out.println("Encrypted value: " + encryptedValue); //prints final value
            } else if(thing.equals("2")){
                //creates an Decrypter object
                System.out.println("You selected: Decryption");
                Decrypter myDecrypter = new Decrypter();

                //prompts input
                System.out.printf("Please enter an integer string: ");
                String theInput = input.nextLine();
                String decryptedValue = myDecrypter.decrypt(theInput);;
                System.out.println("Decrypted value: " + decryptedValue); //prints final value
            } else break;
        }
        System.out.println("You ended the program.");
    }
}
