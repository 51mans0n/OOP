package lab2ex5;

public class TestCircuit {
    public static void main(String[] args) {
        Resistor r1 = new Resistor(60);
        Resistor r2 = new Resistor(20);
        Resistor r3 = new Resistor(30);
        Series s1 = new Series(r1, r2);
        Parallel p1 = new Parallel(r3, s1);

        p1.applyPotentialDiff(120);
        s1.applyPotentialDiff(90);

        System.out.println("Сопротивление резистора r1: " + r1.getResistance() + " Ом");
        System.out.println("Сопротивление резистора r2: " + r2.getResistance() + " Ом");
        System.out.println("Сопротивление резистора r3: " + r3.getResistance() + " Ом");
        System.out.println("Общее сопротивление в последовательной схеме s1: " + s1.getResistance() + " Ом");
        System.out.println("Общее сопротивление в параллельной схеме p1: " + p1.getResistance() + " Ом");

        System.out.println("Ток через резистор r1: " + r1.getCurrent() + " А");
        System.out.println("Ток через резистор r2: " + r2.getCurrent() + " А");
        System.out.println("Ток через резистор r3: " + r3.getCurrent() + " А");
        System.out.println("Общий ток в последовательной схеме s1: " + s1.getCurrent() + " А");
        System.out.println("Общий ток в параллельной схеме p1: " + p1.getCurrent() + " А");
    }
}
