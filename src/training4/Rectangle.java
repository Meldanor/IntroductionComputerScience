package training4;

public class Rectangle extends java.awt.Rectangle {

    public boolean intersect(Rectangle r) {

        return this.intersects(r);
    }
}
