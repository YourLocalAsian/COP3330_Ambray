public class Sphere extends Shape3D {
    //constructor
    public Sphere(double length) {
        super(length);
    }
    public double getVolume(){
        return  (Math.PI * 4/3) * Math.pow(length, 3);
    };

    public double getArea(){
        return 4 * Math.PI * Math.pow(length, 2);
    };

    public String getName(){
        return "sphere";
    }


}
