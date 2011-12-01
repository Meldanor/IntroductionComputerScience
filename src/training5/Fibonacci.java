/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training5;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Fibonacci {

    public static BigInteger fib1(int n) {
        if (n == 0 || n == 1)
            return BigInteger.ONE;
        else
            return fib1(n - 2).add(fib1(n - 1));

    }

    public static BigInteger fib3(int n, int counter) {
        if (n == 0 || n == 1)
            return BigInteger.ONE;
        else
            return fib3(n - 2, ++counter).add(fib3(n - 1, ++counter));

    }

    public static BigInteger fib2(int n) {

        BigInteger help = BigInteger.ONE;
        BigInteger current = BigInteger.ONE;
        BigInteger next = BigInteger.ONE;
        int counter = 0;
        for (int i = 2; i <= n; ++i, ++counter) {
            help = next;
            next = current.add(next);
            current = help;
        }
        System.out.println(counter);
        return next;
    }

    public static void test() {
        // for (int i = 0; i <= 20; ++i) {
        // System.out.println("n=" + i);
        // System.out.println("Rek " + fib1(i));
        // System.out.println("Ite " + fib2(i));
        // System.out.println();
        // }

        System.out.println(fib3(22, 0));
        System.out.println(fib2(22));

        BigDecimal goldenCut = BigDecimal.ONE;
        BigDecimal old = BigDecimal.ZERO;
        BigDecimal current = BigDecimal.ONE;
        //
        for (int i = 0; i <= 100; ++i) {
            old = current;
            current = new BigDecimal(fib2(i));
            goldenCut = current.divide(old, 1000, BigDecimal.ROUND_HALF_EVEN);
            System.out.println(goldenCut);
        }
        // goldenCut ca 1,618
        // after 100 numbers : 1.618033988749894848204586834365638
    }
}
