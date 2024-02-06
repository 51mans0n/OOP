package hw4ex1;

class Circle extends Shape {
    private int radius;

    public Circle(int position, Color color, int radius) {
        super(position, color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Draw " + color + " Circle with radius = " + radius + " and position = " + position);
        if(color == Color.RED) {
            System.out.println("\u001B[31m");
        }
        else if (color == Color.GREEN) {
            System.out.println("\u001B[32m");
        }
        else System.out.println("\u001B[34m");
        for (int y = 0; y <= 2 * radius; y++) {
            for (int temp = 0 ; temp < position ; temp++) {
                System.out.print("\t");
            }
            for (int x = 0; x <= 2 * radius; x++) {
                int dx = x - radius;
                int dy = y - radius;
                if (dx * dx + dy * dy <= radius * radius) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
