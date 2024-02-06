package lab2ex1a;

import java.util.Vector;

public class testShapes {
    public static void main (String[] args) {
        Vector<Shapes> shapes = new Vector<>();
        shapes.add(new Cylinder(3, 10));
        shapes.add(new Sphere(5));
        shapes.add(new Cube(6));
        for (Shapes shape : shapes) {
            shape.volume();
            shape.surfaceArea();
        }
    }
}
