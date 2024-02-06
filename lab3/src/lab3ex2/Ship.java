package lab3ex2;

public class Ship implements Swimable {
    public Ship () {

    }
    @Override
    public void start() {
        System.out.println("Ship started to swim");
    }
    @Override
    public void stop() {
        System.out.println("Ship stopped");
    }
    @Override
    public void swim() {
        System.out.println("Ship is swimming!");
    }
}
