package hw3ex1;

public class Tortoise extends Animal {
    protected Tortoise(String name, int age, int weight) {
        super(name, age, weight);
    }

    public Tortoise() {
        super();
    }

    @Override
    public String getValues() {
        return super.getValues() + "Test";
    }
}
