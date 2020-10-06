public class Square extends Shape2D {
    //constructor
    public Square (double length) {
        super(length);
    }

    public double getArea(){
        return Math.pow(length, 2);
    };

    public String getName(){
        return "square";
    }
}
