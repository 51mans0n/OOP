package hw3ex2;

import java.util.Vector;

public class TestPerson {
    public static void main(String[] args) {

        Person newPerson = new Person("Alex", "Pushkin street, Kolotushkin house");
        Person newStudent = new Student("Vanya", "Satpayeva, Seifullina, 7a", "CIS", 4, 3000);
        Person newStaff = new Staff("Dmitriy", "Russia, St. Petersburg, Lomonosova 16", "SITE", 350000);
        Vector<Person> allMembers = new Vector<>();
        allMembers.add(newPerson);
        allMembers.add(newStudent);
        allMembers.add(newStaff);
        for(Person p:allMembers){
            System.out.println(p);
        }
    }
}
// если 1 ввод если 2 вывод если 3 выход