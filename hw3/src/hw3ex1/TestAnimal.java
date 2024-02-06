package hw3ex1;

import java.util.Scanner;

public class TestAnimal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Dog GermanShepherd = new Dog("Rex", 4, 26, true);
        Tortoise TestudoHorsfieldii  = new Tortoise("Franky", 53, 9);
        System.out.println(GermanShepherd.getValues());
        System.out.println(TestudoHorsfieldii.getValues());

    }
}
