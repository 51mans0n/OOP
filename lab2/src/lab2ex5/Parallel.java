package lab2ex5;

import java.util.ArrayList;
import java.util.List;

public class Parallel extends Circuit {
    private List<Circuit> circuits = new ArrayList<>();

    public Parallel(Circuit... circuits) {
        for (Circuit circuit : circuits) {
            this.circuits.add(circuit);
        }
    }

    @Override
    public double getResistance() {
        double inverseTotalResistance = 0;
        for (Circuit circuit : circuits) {
            inverseTotalResistance += 1 / circuit.getResistance();
        }
        return 1 / inverseTotalResistance;
    }

    @Override
    public void applyPotentialDiff(double V) {
        this.potentialDiff = V;
        for (Circuit circuit : circuits) {
            circuit.applyPotentialDiff(V);
        }
    }
}

