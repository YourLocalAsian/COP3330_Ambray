public class Triangle extends Shape2D {
    private double width;

    //constructor
    public Triangle (double length, double width) {
        super(length);
        this.width = width;
    }

    public double getArea(){
        return .5 * length * width;
    };

    public String getName(){
        return "triangle";
    }
}
