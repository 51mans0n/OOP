package lab3ex1;

public class Car extends Transport implements Startable {
    private String brand;
    private String model;
    public Car(int year, int speed, String brand, String model) {
        super(year, speed);
        this.brand = brand;
        this.model = model;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public void move() {
        System.out.println("Car is moving");
    }
    @Override
    public void start() {
        System.out.println("Car started to work");
    }
    public String toString(){
        return "Brand of the Car: " + getBrand() + " Model: " + getModel() + " Year of manufacture: " + getYear() + " Have speed: " + getSpeed();
    }
}
