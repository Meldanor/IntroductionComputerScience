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

public class TestGeo {

    public static void test() {
        Point a = new Point();
        System.out.println(a.toString());
        a.translate(1, 1);
        System.out.println(a.toString());

        Point b = new Point(1, 5);
        Line l = new Line(a);
        System.out.println(l + " with length = " + l.length());
        l = new Line(a, b);
        System.out.println(l + " with length = " + l.length());
        l.translate(1, 1);
        System.out.println(l + " with length = " + l.length());

        Triangle t = new Triangle(a, b);
        System.out.println(t + " with perimeter = " + t.perimeter());
    }
}
