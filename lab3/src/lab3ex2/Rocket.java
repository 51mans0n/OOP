package lab3ex2;

public class Rocket implements Movable {
    public Rocket() {

    }
    @Override
    public void start() {
        System.out.println("Rocket started moving");
    }
    @Override
    public void stop() {
        System.out.println("Rocket stopped");
    }
}
