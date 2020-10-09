public class Circle extends Shape2D {
    //constructor
    public Circle (double length) {
        super("circle",length, 0);
    }

    //concrete method
    public double getArea(){
        return Math.PI * Math.pow(length, 2);
    }
}