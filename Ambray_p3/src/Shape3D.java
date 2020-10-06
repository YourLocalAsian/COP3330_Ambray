public abstract class Shape3D extends Shape{
    //constructor
    public Shape3D(double length){
        super(length);
    }

    //methods
    public abstract double getVolume();

    public abstract double getArea();

    public abstract String getName();
}
