public class BodyMassIndex {
    public static final double NORMAL = 18.5;
    public static final double OVERWEIGHT = 25;
    public static final double OBESITY = 30;

    private double height;
    private double weight;
    private String bmiCategory = "";
    private double personBMI;

    //BodyMassIndex Constructor
    public BodyMassIndex(double height, double weight){
        this.height = height;
        this.weight = weight;
    }

    //Calculator for BMI
    public double calculateBMI(double height, double weight){
        personBMI = 703 * weight / (height * height);
        return personBMI;
    }

    //Categories BMI
    public static String categorizeBMI(double testBMI){
        if(testBMI >= OBESITY){
            return "Obese";
        }
        else if(testBMI >= OVERWEIGHT){
            return "Overweight";
        }
        else if(testBMI >= NORMAL) {
            return "Normal";
        }
        else return "Underweight";
    }
}
