public class Pyramid extends Shape3D{
    //constructor
    public Pyramid(double length, double width, double height) {
        super("pyramid", length, width, height);
    }

    //concrete methods
    public double getVolume(){
        return length * width * height / 3;
    }

    public double getArea(){
        return (length * width) + (length * Math.pow(Math.pow(width/2, 2) + Math.pow(height, 2), 0.5)) + (width * Math.pow(Math.pow(length/2, 2) + Math.pow(height, 2), 0.5));
    }
}
