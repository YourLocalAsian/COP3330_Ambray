public abstract class Shape {
    //attributes shared by all shapes
    protected final String name;
    protected final double length;
    protected final double width;

    //constructor
    public Shape(String name, double length, double width){
        this.name = name;
        this.length = length;
        this.width = width;
    }

    //abstract methods
    public abstract String getName();
    public abstract double getArea();


}