package hw6ex1;

public interface Shape {
    double getArea();
    String toString();
    default double getPerimeter() {
        return 0;
    }
}
