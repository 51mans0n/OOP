package hw4ex1;
import java.util.Vector;

public class TestShape {
    public static void main(String[] args) {
        Vector<Shape> shapes = new Vector<>();
        shapes.add(new Circle(3, Color.GREEN, 3));
        shapes.add(new Rectangle(2, Color.BLUE, 3, 3));
        shapes.add(new Triangle(5, Color.RED,  4));
        Shape shape1=new Triangle(5,Color.RED,4);
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
