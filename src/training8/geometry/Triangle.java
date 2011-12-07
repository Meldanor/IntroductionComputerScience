/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training8.geometry;

public class Triangle implements Moveable {

    private Point a;
    private Point b;
    private Point c;

    @SuppressWarnings("unused")
    private Triangle() {
        // Disallow an empty triangle
    }

    public Triangle(int x2, int y2, int x3, int y3) {
        this(new Point(x2, y2), new Point(x3, y3));
    }

    public Triangle(Point b, Point c) {
        this(new Point(0, 0), b, c);
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
    }

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void translate(int dx, int dy) {
        a.translate(dx, dy);
        b.translate(dx, dy);
        c.translate(dx, dy);
    }

    @Override
    public String toString() {
        return "A" + a.toString() + " B" + b.toString() + " C" + c.toString();
    }

    public double perimeter() {
        return new Line(a, b).length() + new Line(b, c).length()
                + new Line(c, a).length();
    }
}
