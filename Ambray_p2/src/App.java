import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
        if(prompt.equalsIgnoreCase("y")){
            return true;
        }
        else if(prompt.equalsIgnoreCase("n")) {
            return false;
        } else {
            System.out.println("That is not a valid operator!");
            return moreInput();
        }
    }

    public static double getUserHeight(){
        System.out.println("Please enter a height in inches: ");
        try{
            double tempHeight = userInput.nextDouble();
            userInput.nextLine();

            if(tempHeight > 0){
                return tempHeight;
            }
            else {
                System.out.println("Only heights greater than 0 are accepted.");
                return getUserHeight();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Only numerical values are valid inputs.");
            userInput.nextLine();
            return getUserHeight();
        }
    }

    public static double getUserWeight(){
        System.out.println("Please enter a weight in pounds: ");
        try {
            double tempWeight = userInput.nextDouble();
            userInput.nextLine();

            if (tempWeight > 0) {
                return tempWeight;
            } else {
                System.out.println("Only weights greater than 0 are accepted.");
                return getUserWeight();
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Only numerical values are valid inputs.");
            userInput.nextLine();
            return getUserWeight();
        }
    }

    public static void displayBmiInfo(BodyMassIndex bmi_x){
    //prints out a user's BMi score and category using the data contained in a BodyMassIndex object
        double tempBMI = bmi_x.calculateBMI();
        System.out.printf("%nThe BMI of this user is: %.1f%n", tempBMI);
        System.out.println("This person would be classified as: " + BodyMassIndex.categorizeBMI(tempBMI));
        System.out.println();
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmi_y){
    //prints out the average BMI score of the data
        double totalBMI = 0;
        for(BodyMassIndex person : bmi_y){
           totalBMI += person.calculateBMI();
        }

        double avgBMI = totalBMI / bmi_y.size();
        System.out.printf("%nThe average BMI is: %.1f%n", avgBMI);
        System.out.println("The average person would be classified as: " + BodyMassIndex.categorizeBMI(avgBMI));
    }
}
