package lab1ex3;

public class testTemperature {
    public static void main(String[] argc) {
        Temperature temp = new Temperature(59, 'C');
        System.out.println(temp.getCelsiumTemperature());
        System.out.println(temp.getFahrenheitTemperature());
    }
}
