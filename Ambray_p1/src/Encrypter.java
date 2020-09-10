//Encrypts data using pre-determined algorithm
import static java.lang.Integer.parseInt;

public class Encrypter {
    private int conValue;
    private int[] conArray = new int[4];
    private int tempDigit = 0;
    private String finalValue;

    public String encrypt(String input){
        convertInt(input);
        addModMain();
        swapDigit();
        convertStr();
        return finalValue;

    }

    public void convertInt(String input){ //Converts string into individual integers
        this.conValue = parseInt(input);
        this.conArray[0] = this.conValue/1000;
        //System.out.println("Thousands: " + conArray[0]);
        this.conArray[1] = (this.conValue - 1000*this.conArray[0])/100;
        //System.out.println("Hundreds: " + conArray[1]);
        this.conArray[2] =  (this.conValue - 1000*this.conArray[0] - 100*this.conArray[1])/10;
        //System.out.println("Tens: " + conArray[2]);
        this.conArray[3] = this.conValue % 10;
        //System.out.println("Ones: " + conArray[3]);
        //System.out.println();
    }

    public void addModMain(){
        this.conArray[0] = addModSub(this.conArray[0]);
        this.conArray[1] = addModSub(this.conArray[1]);
        this.conArray[2] = addModSub(this.conArray[2]);
        this.conArray[3] = addModSub(this.conArray[3]);
    }

    public int addModSub(int subDigit){
        subDigit = (subDigit + 7) % 10;
        //System.out.println(subDigit);
        return subDigit;
    }

    public void swapDigit(){
        this.tempDigit = this.conArray[2];
        this.conArray[2] = this.conArray[0];
        this.conArray[0] = this.tempDigit;
        this.tempDigit = this.conArray[3];
        this.conArray[3] = this.conArray[1];
        this.conArray[1] = this.tempDigit;
    }

    public void convertStr(){
        this.conValue = this.conArray[0]*1000 + this.conArray[1]*100 + this.conArray[2]*10 + this.conArray[3];
        this.finalValue = String.format("%04d", this.conValue);
    }
}
