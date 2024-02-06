package hw6ex1;

public class Rectangle implements Shape{
    private double length;
    private double width;
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
    @Override
    public String toString() {
        System.out.println("Rectangle with length: " + length + " and width: " + width);
        return null;
    }
    @Override
    public double getPerimeter() {
        return 2 * (length + width);
    }
}
