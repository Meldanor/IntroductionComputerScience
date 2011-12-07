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

public class Line implements Moveable {

    private Point start;
    private Point end;

    @SuppressWarnings("unused")
    private Line() {
        // Disallow an empty line
    }

    public Line(int x, int y) {
        this(new Point(x, y));
    }

    public Line(Point p) {
        this(new Point(0, 0), p);
    }

    public Line(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public void translate(int dx, int dy) {
        start.translate(dx, dy);
        end.translate(dx, dy);
    }

    public double length() {
        return start.distance(end);
    }

    @Override
    public String toString() {
        return "S" + start.toString() + " S'" + end.toString();
    }

}
