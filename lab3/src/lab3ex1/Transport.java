package lab3ex1;

abstract public class Transport {
    private int speed;
    private int year;
    public Transport(int speed, int year) {
        this.speed = speed;
        this.year = year;
    }
    abstract public void move();
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
}
