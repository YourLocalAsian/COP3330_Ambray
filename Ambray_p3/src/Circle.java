public class Circle extends Shape2D {
    //constructor
    public Circle (double length) {
        super(length);
    }

    public double getArea(){
        return Math.PI * Math.pow(length, 2);
    };

    public String getName(){
        return "circle";
    }
}