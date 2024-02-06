package lab1ex5;

public class Person {
    private Gender gender;
    private String name;
    public Person(Gender gender, String name) {
        this.gender = gender;
        this.name = name;
    }
    public Gender getGender() {
        return gender;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return name;
    }
}
