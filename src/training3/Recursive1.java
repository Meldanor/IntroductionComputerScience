/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training3;

/**************************************
 * Die Funktion berechnet x - y . Sie terminiert nicht wenn y < 0.
 ***********************************************/
public class Recursive1 {

    public static int rek(int x, int y) {
        if (y == 0)
            return x;
        else if (y < 0)
            return rek(++x, ++y);
        else
            return rek(--x, --y);
    }

    public static int iter(int x, int y) {

        while (y != 0) {
            if (y < 0) {
                ++x;
                ++y;
            }
            else {
                --x;
                --y;
            }
        }
        return x;
    }

    public static void test() {
        System.out.println(rek(246, -8));
        System.out.println(rek(20, 10));
        System.out.println(rek(100, 5));
        System.out.println(rek(-100, -5));
        System.out.println(rek(100, -5));

        System.out.println();

        System.out.println(iter(20, 10));
        System.out.println(iter(100, 5));
        System.out.println(iter(-100, -5));
        System.out.println(iter(100, -5));

    }

}
