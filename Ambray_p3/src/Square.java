public class Square extends Shape2D {
    public Square (double length) {
        super(length);
    }

    @Override
    public double getArea(){
        return length * length;
    };


}
