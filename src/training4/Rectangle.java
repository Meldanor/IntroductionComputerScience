package training4;

public class Rectangle extends java.awt.Rectangle {

    public Rectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public boolean intersect(Rectangle r2) {

        return super.intersects(r2);
    }

}
