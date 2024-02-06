package lab3ex5;

public class Chocolate implements Comparable<Chocolate> {
    private double weight;
    private String name;
    public Chocolate(double weight, String name) {
        this.weight = weight;
        this.name = name;
    }
    @Override
    public int compareTo(Chocolate other) {
        return Double.compare(this.weight, other.weight);
    }
    @Override
    public String toString() {
        return "Chocolate with name" + name + " Weight: " + weight;
    }
}
