public class Triangle extends Shape2D {
    private double width;

    //constructor
    public Triangle (double length, double width) {
        super(length);
        this.width = width;
    }

    @Override
    public double getArea(){
        return .5 * length * width;
    };

    @Override
    public String getName(){
        return "triangle";
    }

    static class Circle extends Shape2D {
        //constructor
        public Circle (double length) {
            super(length);
        }

        @Override
        public double getArea(){
            return Math.PI * Math.pow(length, 2);
        };

        @Override
        public String getName(){
            return "circle";
        }
    }
}
