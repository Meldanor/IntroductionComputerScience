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

public class Point implements Moveable {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(this.getX() - p.getX(), 2)
                + Math.pow(this.getY() - p.getY(), 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
