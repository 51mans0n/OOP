package lab1ex3;

public class Temperature {
    private double temperatureVal;
    private char scale;
    public Temperature() {
        scale = 'C';
        temperatureVal = 0;
    }
    public Temperature (char scale) {
        this.scale = scale;
        temperatureVal = 0;
    }
    public Temperature (double temperatureVal) {
        this.temperatureVal = temperatureVal;
        scale = 'C';
    }
    public Temperature (double temperatureVal, char scale) {
        this.temperatureVal = temperatureVal;
        this.scale = scale;
    }
    public void setVal(double temperatureVal) {
        this.temperatureVal = temperatureVal;
    }
    public void setScale(char scale) {
        this.scale = scale;
    }
    public char getScale() {
        return scale;
    }
    public double getTemperatureVal () {
        return temperatureVal;
    }
    public double getFahrenheitTemperature() {
        if(scale == 'F') {
            return temperatureVal;
        }
        else return 9 * (temperatureVal / 5) + 32;
    }
    public double getCelsiumTemperature() {
        if(scale == 'C') {
            return temperatureVal;
        }
        else return 5 * (temperatureVal - 32) / 39;

    }
}
