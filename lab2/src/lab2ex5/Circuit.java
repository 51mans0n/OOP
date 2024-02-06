package lab2ex5;

public abstract class Circuit {
    protected double potentialDiff; // напряжение V

    public abstract double getResistance(); // сопротивление R

    public double getPotentialDiff() {
        return potentialDiff;
    }

    public abstract void applyPotentialDiff(double V);

    public double getPower() {  // мощность P
        return Math.pow(potentialDiff, 2) / getResistance();
    }

    public double getCurrent() { // сила тока I
        return potentialDiff / getResistance();
    }
}

