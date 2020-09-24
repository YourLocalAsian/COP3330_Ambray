import java.util.ArrayList;
import java.util.Scanner;

public class App {

    Scanner userInput = new Scanner;

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
        return true;
    }


    public static int getUserHeight(){
    //prompts for height in inches & only accepts positive values
        //create local variable and set it to inputDouble
        //if > 0, return input
        //else print prompt for valid value
            //call function again
    }

    public static int getUserWeight(){
    //prompts for weight in lbs and only accepts positive values
    }

    public static void displayBmiInfo(BodyMassIndex bmi_x){
    //prints out a user's BMi score and category using the data contained in a BodyMassIndex object
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmi_y){
    //prints out the average BMI score of the data
    }
}
