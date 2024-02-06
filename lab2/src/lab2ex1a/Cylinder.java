package lab2ex1a;

public class Cylinder extends Shapes {
    private double radius;
    private double height;
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    {
        System.out.println("Cylinder was created.");
    }
    @Override
    public void volume() {
        System.out.println("Volume of the Cylinder: " + (PI * Math.pow(radius, 2) * height));
    }
    @Override
    public void surfaceArea() {
        System.out.println("Surface area of the Cylinder: " + (2 * PI * radius * height + 2 * Math.PI * Math.pow(radius, 2)));
    }
}
