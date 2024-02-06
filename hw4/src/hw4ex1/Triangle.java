package hw4ex1;

class Triangle extends Shape {
    private int height;

    public Triangle(int position, Color color, int height) {
        super(position, color);
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("\u001B[0m" + "Draw " + color + " Triangle with height = " + height + " and position = " + position);
        if(color == Color.RED) {
            System.out.println("\u001B[31m");
        }
        else if (color == Color.GREEN) {
            System.out.println("\u001B[32m");
        }
        else System.out.println("\u001B[34m");
        for (int i = 1; i <= height; i++) {
            for (int temp = 0 ; temp < position ; temp++) {
                System.out.print("\t");
            }
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
