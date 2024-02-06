package lab3ex2;

public class TestMoving {
    public static void main(String[] args) {
        Ship ship1 = new Ship();
        Rocket rocket1 = new Rocket();

        rocket1.start();
        rocket1.stop();
        ship1.start();
        ship1.stop();
        ship1.swim();
    }
}
