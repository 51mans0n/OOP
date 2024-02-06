package lab2ex5;

import java.util.ArrayList;
import java.util.List;

public class Series extends Circuit {
    private List<Circuit> circuits = new ArrayList<>();

    public Series(Circuit... circuits) {
        for (Circuit circuit : circuits) {
            this.circuits.add(circuit);
        }
    }

    @Override
    public double getResistance() {
        double totalResistance = 0;
        for (Circuit circuit : circuits) {
            totalResistance += circuit.getResistance();
        }
        return totalResistance;
    }

    @Override
    public void applyPotentialDiff(double V) {
        this.potentialDiff = V;
        double current = getCurrent();
        for (Circuit circuit : circuits) {
            circuit.applyPotentialDiff(current * circuit.getResistance());
        }
    }
}

