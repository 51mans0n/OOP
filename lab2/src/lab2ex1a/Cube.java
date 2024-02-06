package lab2ex1a;

public class Cube extends Shapes {
    private double side;
    public Cube(double side) {
        this.side = side;
    }
    {
        System.out.println("Cube was created.");
    }
    @Override
    public void volume() {
        System.out.println("Volume of the Cube: " + (Math.pow(side, 3)));
    }
    @Override
    public void surfaceArea() {
        System.out.println("Surface area of the Cube: " + (6 * Math.pow(side, 2)));
    }
}
