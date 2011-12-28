/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training10;

public class Triangle {

    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c) throws TriangleException {
        if (a == 0.0 || b == 0.0 || c == 0.0)
            throw new TriangleException("[" + getClass().getName()
                    + "] Can't create instance with a='" + a + "', b='" + b
                    + "', c='" + c + "'");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calculateArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public double calculatePerimeter() {
        return a + b + c;
    }

    public static void test() {
        try {
            Triangle t = new Triangle(1.0, 2.0, 3.0);
            System.out.println(t.calculateArea());
            System.out.println(t.calculatePerimeter());
            Triangle t2 = new Triangle(0.0, 1.0, 3.0);
            // can't do anything because t2 will throw an exception
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
