package lab1ex5;

public class testDragon {
    public static void main(String[] argc) {
        DragonLaunch lunch = new DragonLaunch();

        lunch.kidnap(new Person(Gender.BOY,"Alexandr"));
        lunch.kidnap(new Person(Gender.GIRL,"Nastya"));
        lunch.kidnap(new Person(Gender.GIRL,"Dima"));
        lunch.kidnap(new Person(Gender.GIRL,"Lena"));
        lunch.kidnap(new Person(Gender.GIRL,"Katya"));
        lunch.kidnap(new Person(Gender.BOY,"Kirill"));

        System.out.print(lunch.willDragonEatOrNot());
    }
}
