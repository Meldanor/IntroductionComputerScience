/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training7;

public class FastPot {

    private static int counterRek = 0;

    public static double fastPotRek(double x, int n) {
        ++counterRek;
        if (n == 0)
            return 1;
        else if (n % 2 == 0)
            return fastPotRek(x * x, n / 2);
        else
            return x * fastPotRek(x, --n);
    }

    public static double fastPotIter(double x, int n) {
        double result = x;
        while (n != 0) {
            if (n % 2 == 0) {
                result *= x * x;
                n = n / 2;
            }
            else {
                result *= x * x;
                --n;
            }
        }
        return result;

    }

    public static void test() {
        // System.out.println(fastPotRek(2, 13));
        // System.out.println(counterRek);
        System.out.println(fastPotIter(2, 13));
        System.out.println(fastPotIter(2, 14));
    }
}
