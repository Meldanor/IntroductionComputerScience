/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training1;


public class Training1 {

    public void test() {

        try {
            System.out.println(isPrime(1));
            System.out.println(isPrime(5));
            System.out.println(isPrime(83));
            System.out.println(isPrime(85));
            System.out.println(nextPrime(2));
            System.out.println(nextPrime(10));
            System.out.println(nextPrime(32));
            System.out.println(nextPrime(99900));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isPerfectNumber(int number) {
        int sum = 0;
        for (int i = 1; i < number; ++i)
            if (number % i == 0)
                sum += i;
        return sum == number;
    }

    public static boolean isPrime(int number) {
        if (number == 2)
            return true;
        if (number == 1 || number % 2 == 0)
            return false;

        for (int i = 3; i < number / 2; i += 2)
            if (number % i == 0)
                return false;

        return true;
    }

    public static int nextPrime(int number) {

        if (isPrime(number))
            return number;
        if (number == 1)
            return 2;
        if (number % 2 == 0)
            ++number;
        while (!isPrime(number))
            number += 2;

        return number;
    }
}