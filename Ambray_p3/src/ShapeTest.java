import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.;

class ShapeTest {
    @Test
    public void testSquareName(){
        Shape shape = new Square(10);
        assertEquals("square", shape.getName());
    }

    @Test
    public void testSquareArea(){
        Shape2D shape = new Square(10);
        assertEquals(100, shape.getArea());
    }

    @Test
    public void testSquareArea2(){
        Shape2D shape = new Square(0.5);
        assertEquals(0.25, shape.getArea());
    }



    @Test
    public void testTriangleName(){
        Shape shape = new Triangle(100, 100);
        assertEquals("triangle", shape.getName());
    }

    @Test
    public void testTriangleArea(){
        Shape2D shape = new Triangle(10, 10);
        assertEquals(50, shape.getArea());
    }

    @Test
    public void testTriangleArea2(){
        Shape2D shape = new Triangle(0.5, 0.25);
        assertEquals(0.063, shape.getArea());
    }



    @Test
    public void testCircleName(){
        Shape shape = new Circle(10);
        assertEquals("circle", shape.getName());
    }

    @Test
    public void testCircleArea(){
        Shape2D shape = new Circle(10);
        assertEquals(314.16, shape.getArea(), 0.01);
    }

    @Test
    public void testCircleArea2(){
        Shape2D shape = new Circle(10);
        assertEquals(.79, shape.getArea(), 0.01);
    }



    //3D Shapes
    @Test
    public void testCubeName(){
        Shape shape = new Cube(100);
        assertEquals("cube", shape.getName());
    }

    @Test
    public void testCubeArea(){
        Shape3D shape = new Cube(10);
        assertEquals(600, shape.getArea());
    }

    @Test
    public void testCubeArea2() {
        Shape3D shape = new Cube(0.5);
        assertEquals(1.5, shape.getArea(), 0.01);
    }
}