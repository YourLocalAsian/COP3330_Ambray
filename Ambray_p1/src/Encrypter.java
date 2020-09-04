// Encrypter.java
// Encrypts data using pre-determined algorithm

public class Encrypter {
    private int conValue;
    private int thousands;
    private int hundreds;
    private int tens;
    private int ones;

    //Methods
    public void encrypt(String input){
        conversion(input);
    }

    public void conversion(String input){
        conValue = parseInt(input);
        thousands = conValue/1000;
        System.out.println("Thousands: " + thousands);
    }

    public void addSeven_modTen(int value){
        value = value + 7;

    }



    public void swapDigit(){

    }
}