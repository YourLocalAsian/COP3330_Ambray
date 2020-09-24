public class BodyMassIndex {
    public static final double NORMAL = 18.5;
    public static final double OVERWEIGHT = 25;
    public static final double OBESITY = 30;

    private double height;
    private double weight;

    //BodyMassIndex Constructor
    public BodyMassIndex(double height, double weight){
        this.height = height;
        this.weight = weight;
    }

    //Calculator for BMI
    public double calculateBMI(){
        return 703 * weight / (height * height);
    }

    //Categories BMI
    public static String categorizeBMI(double inputBMI){
        if(inputBMI >= OBESITY){
            return "Obese";
        }
        else if(inputBMI >= OVERWEIGHT){
            return "Overweight";
        }
        else if(inputBMI >= NORMAL) {
            return "Normal";
        }
        else return "Underweight";
    }
}
