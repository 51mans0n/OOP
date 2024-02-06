package hw3ex1;

public class Animal {
    protected String name;
    private int age;
    private int weight;

    public Animal() {
    }

    protected Animal(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    protected int getAge(int age) {
        return age;
    }
    protected int getWeight(int weight) {
        return weight;
    }
    protected String getName(String name) {
        return name;
    }
    public String getValues() {
        return "Name: " + String.valueOf(this.getName(name)) + "\n" + "Age: " + String.valueOf(this.getAge(age)) + "\n" + "Weight: " + String.valueOf(this.getWeight(weight)) + "\n";
    }
}
