public class Triangle extends Shape2D {
    //constructor
    public Triangle (double length, double width) {
        super("triangle",length, width);
    }

    //concrete method
    public double getArea(){
        return .5 * length * width;
    }
}
