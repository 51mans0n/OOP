package hw2ex1;

public class Student {
    public String name;
    public int id;
    public int yearOfStudy;
    public Student () {
        incrementYear();
    }
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        incrementYear();
    }
    public void incrementYear() {
        yearOfStudy++;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String toString() {
        return this.name + "\t" + this.id + "\t" + this.yearOfStudy;
    }
}
