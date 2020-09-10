//Encrypts data using pre-determined algorithm
import static java.lang.Integer.parseInt;

public class Decrypter {
    private int conValue;
    private int[] conArray = new int[4];
    private int tempDigit = 0;
    private String finalValue;

    public String decrypt(String input){
        convertInt(input);
        swapDigit();
        modSub();
        convertStr();
        return finalValue;

    }

    public void convertInt(String input){ //Converts string into individual integers
        this.conValue = parseInt(input);
        this.conArray[0] = conValue/1000;
        //System.out.println("Thousands: " + conArray[0]);
        this.conArray[1] = (conValue - 1000*conArray[0])/100;
        //System.out.println("Hundreds: " + conArray[1]);
        this.conArray[2] =  (conValue - 1000*conArray[0] - 100*conArray[1])/10;
        //System.out.println("Tens: " + conArray[2]);
        this.conArray[3] = conValue % 10;
        //System.out.println("Ones: " + conArray[3]);
        //System.out.println();
    }

    public void swapDigit(){
        this.tempDigit = this.conArray[2];
        this.conArray[2] = this.conArray[0];
        this.conArray[0] = this.tempDigit;
        this.tempDigit = this.conArray[3];
        this.conArray[3] = this.conArray[1];
        this.conArray[1] = this.tempDigit;
    }

    public void modSub(){
        this.conArray[0] = sub(this.conArray[0]);
        this.conArray[1] = sub(this.conArray[1]);
        this.conArray[2] = sub(this.conArray[2]);
        this.conArray[3] = sub(this.conArray[3]);
    }

    public int sub(int subDigit){
        subDigit = (subDigit - 7);
        if(subDigit < 0) {
            subDigit += 10;
        }
        //System.out.println(subDigit);
        return subDigit;
    }

    public void convertStr(){
        this.conValue = this.conArray[0]*1000 + this.conArray[1]*100 + this.conArray[2]*10 + this.conArray[3];
        this.finalValue = String.format("%04d", this.conValue);
    }
}
