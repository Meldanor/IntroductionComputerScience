/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training6;

public class FarmerMult {
    public static int farmerMultRek(int x, int y) {
        if (x == 1)
            return y;
        if (x % 2 == 1)
            return y + farmerMultRek(x / 2, y * 2);
        else
            return farmerMultRek(x / 2, y * 2);
    }

    public static int farmerMultIter(int x, int y) {
        // minimize the loops by swapping numbers
        if (y < x) {
            int help = y;
            y = x;
            x = help;
        }
        System.out.println(x + "  " + y);
        // only sum when left side is odd
        int sum = x % 2 == 1 ? y : 0;
        while (x != 1) {
            x /= 2;
            y *= 2;
            if (x % 2 == 1)
                sum += y;
            System.out.println(x + "  " + y);
        }
        return sum;
    }

    public static void test() {
        // 2214
        System.out.println(farmerMultIter(27, 82));
        System.out.println();
        // 2214
        System.out.println(farmerMultIter(82, 27));
        System.out.println();
        // 2214
        System.out.println(farmerMultRek(27, 82));
        System.out.println();
        // 2214
        System.out.println(farmerMultRek(82, 27));
    }
}
