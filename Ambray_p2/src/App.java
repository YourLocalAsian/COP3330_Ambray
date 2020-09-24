import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    //moreInput - prompts Y or N and returns bool
    public static boolean moreInput(){
        System.out.println("Would you like to input data? (Y/N)");
        String prompt = userInput.nextLine();
        userInput.nextLine();
        if(prompt.equalsIgnoreCase("y")){
            return true;
        } else return false;
    }

    public static double getUserHeight(){
        System.out.println("Please enter a height in inches: ");
        double tempHeight = userInput.nextDouble();
        userInput.nextLine();

        if(tempHeight > 0){
            return tempHeight;
        }
        else {
            System.out.println("Only heights greater than 0 are accepted.");
            getUserHeight();
        }
    }

    public static double getUserWeight(){
        System.out.println("Please enter a weight in pounds: ");
        double tempWeight = userInput.nextDouble();
        userInput.nextLine();

        if(tempWeight > 0){
            return tempWeight;
        }
        else {
            System.out.println("Only weights greater than 0 are accepted.");
            getUserWeight();
        }
    }

    public static void displayBmiInfo(BodyMassIndex bmi_x){
    //prints out a user's BMi score and category using the data contained in a BodyMassIndex object
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmi_y){
    //prints out the average BMI score of the data
    }
}
