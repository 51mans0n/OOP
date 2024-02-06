package hw6ex1;

public class TestShape {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 5);
        Circle circle1 = new Circle(3);
        circle1.setColor("Blue");

        circle.toString();
        rectangle.toString();
        circle1.toString();

        System.out.println("\nRectangle area: " + rectangle.getArea());
        System.out.println("Circle area: " + circle.getArea());
        System.out.println("Colored circle area: " + circle1.getArea() + "\n");

        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());
        System.out.println("Circle perimeter: " + circle.getPerimeter());
        System.out.println("Colored circle perimeter: " + circle1.getPerimeter());

        System.out.println("\nColor of circle: " + circle1.getColor());
    }
}
