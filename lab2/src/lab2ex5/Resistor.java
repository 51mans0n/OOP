package lab2ex5;

public class Resistor extends Circuit {
    private double resistance;

    public Resistor(double resistance) {
        this.resistance = resistance;
    }

    @Override
    public double getResistance() {
        return resistance;
    }

    @Override
    public void applyPotentialDiff(double V) {
        this.potentialDiff = V;
    }
}

