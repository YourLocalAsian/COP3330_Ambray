public class Cube extends Shape3D {
    //constructor
    public Cube(double length) {
        super(length);
    }

    //methods
    public double getVolume(){
        return Math.pow(length, 3);
    };

    public double getArea(){
        return 6 * Math.pow(length, 2);
    };

    public String getName(){
        return "cube";
    }
}
