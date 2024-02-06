package lab1ex1;

public class Data {
    private double maxVal = Double.MIN_VALUE;
    private double summary;
    private int counter;
    public void addData(double val) {
        summary += val;
        counter++;
        if(val > maxVal) {
            maxVal = val;
        }
    }
    public Data() {

    }
    public double getMaxVal() {
        return maxVal;
    }
    public double getAverageVal() {
        if (counter > 0) {
            return summary / counter;
        }
        else return 0;
    }
}
