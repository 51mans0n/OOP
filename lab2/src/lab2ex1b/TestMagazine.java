package lab2ex1b;

public class TestMagazine {
    public static void main (String[] args) {
        Magazine magaz = new Magazine("MAXIM", "Nikita", 2003, "01");
        System.out.println(magaz.toString());
        magaz.soldOut();
        magaz.returnItem(magaz);
        magaz.soldOut();

    }
}
