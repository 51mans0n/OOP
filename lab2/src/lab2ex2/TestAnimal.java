package lab2ex2;

import java.util.HashSet;

public class TestAnimal {
    public static void main(String[] args) {
        HashSet<Animal> animals = new HashSet<>();

        animals.add(new Animal("Rostic"));
        animals.add(new Animal("Tusik"));
        animals.add(new Dog("Rex", "German Shepherd"));
        animals.add(new Dog("Guts", "German Shepherd"));
        animals.add(new Dog("Laika", "Labrador"));
        animals.add(new Dog("Laika", "Labrador"));

        System.out.println("Size of hashset: " + animals.size());

        for (Animal animal : animals) {
            animal.speak();
        }

        Animal animal1 = new Animal("Korol");
        Animal animal2 = new Animal("Shut");

        if (animal1.equals(animal2)) {
            System.out.println("animal1 and animal2 equals");
        }
        else {
            System.out.println("animal1 and animal2 not equals");
        }
    }
}
