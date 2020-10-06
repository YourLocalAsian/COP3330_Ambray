public abstract class Shape {
    //Attributes shared by all shapes
    protected String name;
    protected final double length;

    //constructor
    public Shape(double length){
        this.length = length;
    }

    public abstract String getName();
    public abstract double getArea();


}