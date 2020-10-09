public class Sphere extends Shape3D {
    //constructor
    public Sphere(double length) {
        super("sphere", length, 0,0);
    }

    //concrete methods
    public double getVolume(){
        return  (Math.PI * 4/3) * Math.pow(length, 3);
    }

    public double getArea(){
        return 4 * Math.PI * Math.pow(length, 2);
    }
}
