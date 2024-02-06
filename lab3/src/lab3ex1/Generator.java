package lab3ex1;

public class Generator implements Startable {
    private int power;
    private String manufacturer;
    public Generator(int power, String manufacturer) {
        this.power = power;
        this.manufacturer = manufacturer;
    }
    public int getPower() {
        return power;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    @Override
    public void start(){
        System.out.println("Generator started to work");
    }
    public String toString() {
        return "Generator with power: " + getPower() + " and manufacturer: " + getManufacturer();
    }
}
