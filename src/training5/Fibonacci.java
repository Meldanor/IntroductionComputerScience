/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training5;

import java.math.BigInteger;

public class Fibonacci {

    public static BigInteger fib1(int n) {
        if (n == 0)
            return BigInteger.ZERO;
        if (n == 1)
            return BigInteger.ONE;
        else
            return fib1(n - 2).add(fib1(n - 1));

    }

    public static BigInteger fib2(int n) {

        BigInteger help = BigInteger.ONE;
        BigInteger current = BigInteger.ZERO;
        BigInteger next = BigInteger.ONE;
        for (int i = 2; i <= n; ++i) {
            help = next;
            next = current.add(next);
            current = help;
        }
        return next;
    }

    public static void test() {
        for (int i = 0; i <= 20; ++i) {
            System.out.println("n=" + i);
            System.out.println("Rek " + fib1(i));
            System.out.println("Ite " + fib2(i));
            System.out.println();
        }
    }
}
