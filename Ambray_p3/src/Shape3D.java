public abstract class Shape3D extends Shape{
    protected double height;

    //constructor
    public Shape3D(String name, double length, double width, double height){
        super(name, length, width);
        this.height = height;
    }

    public String getName(){
        return name;
    }

    //abstract method
    public abstract double getVolume();
}
