public class Square extends Shape2D {
    //constructor
    public Square (double length) {
        super("square", length, length);
    }

    //concrete method
    public double getArea(){
        return Math.pow(length, 2);
    };
}
