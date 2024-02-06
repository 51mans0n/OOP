package lab3ex4;

import java.util.Date;
import java.util.Vector;
import java.util.Collections;

public class TestStaff {
    public static void main(String[] args) {
        Vector<Employee> list = new Vector<>();
        Employee e1 = new Employee("Maxim",2500, new Date(104,07,19),"1");
        Employee e2 = new Employee("Alexandr",5000, new Date(99,03,27),"2");
        Employee e3 = new Employee("Dima",1000, new Date(100,02,14),"3");
        Employee e4 = new Employee("Ekaterina",7500, new Date(78,11,04),"4");

        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);

        Collections.sort(list);

        for(Employee el:list){
            System.out.println(el.toString());
        }
    }
}
