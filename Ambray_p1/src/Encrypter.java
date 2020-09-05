//Encrypts data using pre-determined algorithm
import static java.lang.Integer.parseInt;

public class Encrypter {
    private int conValue;
    int[] conArray = new int[4];
    private int tempDigit = 0;
    private String finalValue;

    public void encrypt(String input){
        convertInt(input);
        addModMain();
        swapDigit();
        convertStr();
        printFinalValue(finalValue);

    }

    public void convertInt(String input){ //Converts string into individual integers
        conValue = parseInt(input);
        conArray[0] = conValue/1000;
        //System.out.println("Thousands: " + conArray[0]);
        conArray[1] = (conValue - 1000*conArray[0])/100;
        //System.out.println("Hundreds: " + conArray[1]);
        conArray[2] =  (conValue - 1000*conArray[0] - 100*conArray[1])/10;
        //System.out.println("Tens: " + conArray[2]);
        conArray[3] = conValue % 10;
        //System.out.println("Ones: " + conArray[3]);
        //System.out.println();
    }

    public void addModMain(){
        conArray[0] = addModSub(conArray[0]);
        conArray[1] = addModSub(conArray[1]);
        conArray[2] = addModSub(conArray[2]);
        conArray[3] = addModSub(conArray[3]);
    }

    public int addModSub(int subDigit){
        subDigit = (subDigit + 7) % 10;
        //System.out.println(subDigit);
        return subDigit;
    }

    public void swapDigit(){
        tempDigit = conArray[2];
        conArray[2] = conArray[0];
        conArray[0] = tempDigit;
        tempDigit = conArray[3];
        conArray[3] = conArray[1];
        conArray[1] = tempDigit;
    }

    public void convertStr(){
        conValue = conArray[0]*1000 + conArray[1]*100 + conArray[2]*10 + conArray[3];
        finalValue = String.format("%04d", conValue);
    }

    public void printFinalValue(String finalValue) {
        System.out.printf("Encrypted string: " + finalValue);
    }
}
