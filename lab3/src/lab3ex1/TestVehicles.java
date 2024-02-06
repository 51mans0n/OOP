package lab3ex1;

public class TestVehicles {
    public static void main(String[] args) {
        Car car1 = new Car(2013, 60, "Tesla", "Model S");
        Generator gen1 = new Generator(450, "Mercedes-Benz");
        Boat boat1 = new Boat(1999, 20, "default", 30);

        car1.start();
        car1.move();
        boat1.move();
        gen1.start();

        System.out.println(car1.toString());
        System.out.println(boat1.toString());
        System.out.println(gen1.toString());
    }
}
