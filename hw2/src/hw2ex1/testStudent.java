package hw2ex1;

public class testStudent {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.id = 1111;
        s1.name = "Maxim";
        Student s2 = new Student("Alex",1112);
        System.out.print("Name\t" + "Id\t" + "Year of study\n" );
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.getId());
        System.out.println(s1.getName());
        s2.incrementYear();
        System.out.println(s2);
        System.out.println("-----");
        System.out.println(s1.toString());
    }
}
