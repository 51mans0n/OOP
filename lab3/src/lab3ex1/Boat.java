package lab3ex1;

public class Boat extends Transport {
    private String type;
    private double lenght;
    public Boat(int year, int speed, String type, double lenght) {
        super(year, speed);
        this.type = type;
        this.lenght = lenght;
    }
    public String getType() {
        return type;
    }
    public double getLenght() {
        return lenght;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setLenght(double lenght) {
        this.lenght = lenght;
    }
    @Override
    public void move() {
        System.out.println("Boat is moving");
    }
    public String toString(){
        return "Type of the Boat: " + getType() + " Length: " + getLenght() + " Year of manufacture: " + getYear() + " Have speed: " + getSpeed();
    }
}
