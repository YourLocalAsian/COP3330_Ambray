public abstract class Shape2D extends Shape {
    //constructor
    public Shape2D(String name, double length, double width){
        super(name, length, width);
    }

    public String getName(){
        return name;
    }
}
