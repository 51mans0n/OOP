package hw4ex1;

abstract class Shape {
    protected int position;
    protected Color color;

    public Shape(int position, Color color) {
        this.position = position;
        this.color = color;
    }

    public abstract void draw();
}
