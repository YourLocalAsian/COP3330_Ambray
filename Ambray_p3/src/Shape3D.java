public abstract class Shape3D extends Shape{
    private final double height;

    public Shape3D(String name, double length, double width, double height){
        super(name, length, width);
        this.height = height;
    }

    public abstract double getVolume();
}
