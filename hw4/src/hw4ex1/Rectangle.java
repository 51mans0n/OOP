package hw4ex1;

class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int position, Color color, int width, int height) {
        super(position, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("\u001B[0m" + "Draw " + color + " Rectange with width = " + width + ", height = " + height + " and position = " + position);
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
            for (int j = 1; j <= width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
