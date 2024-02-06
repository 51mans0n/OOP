package hw2ex3;

public class testTime {
    public static void main(String[] args) {
        Time t = new Time(23,5,6);
        System.out.println(t.toStandard());
        System.out.println(t.toUniversal());
        Time t2 = new Time(4, 24, 33);
        System.out.println(t2.toStandard());
        System.out.println(t2.toUniversal());
        t.add(t2);
        System.out.println(t.toStandard());
        System.out.println(t.toUniversal());
    }
}
