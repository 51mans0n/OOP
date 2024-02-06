package lab2ex1a;

public class Sphere extends Shapes {
    private double radius;
    public Sphere(double radius) {
        this.radius = radius;
    }
    {
        System.out.println("Sphere was created.");
    }
    @Override
    public void volume() {
        System.out.println("Volume of the Sphere: " + ((4 / 3) * PI * Math.pow(radius, 3)));
    }
    @Override
    public void surfaceArea() {
        System.out.println("Surface area of the Sphere: " + (4 * PI * Math.pow(radius, 2)));
    }
}
