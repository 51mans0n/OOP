package lab3ex4;

abstract public class Person {
    private String name;

    public String toString(){
        return "Name:" + name;
    };
    public Person (String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Person p = (Person) o;
        return name.equals(p.name);
    }
}
