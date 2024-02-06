package hw2ex2;

public class StarTriangle {
    public int width;
    public int counter = 1;
    public StarTriangle() {

    }
    public StarTriangle(int width) {
        this.width = width;
    }
    public void counterPlus() {
        counter++;
    }
    public String toString() {
        for(int i = 0; i != width; i++) {
            for(int j = 0; j != counter; j++) {
                System.out.print("[*]");
            }
            counterPlus();
            System.out.print("\n");
        }
        return "";
    }
}
