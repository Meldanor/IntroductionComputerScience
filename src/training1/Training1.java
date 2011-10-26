package training1;

import java.io.BufferedReader;
import java.io.FileReader;

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

    private static double heron(int number) {

        double a = 1;
        double b = number;
        while (Math.abs(a - b) > 0.00000001) {
            a = (a + b) / 2;
            b = number / a;
        }

        return a;
    }

    private static double cubicHeron(int number) {
        double a = 1;
        double b = number;
        double c = number;
        while (Math.abs(a - c) > 0.00000001) {
            a = (a + b) / 2;
            b = number / a;
            c = a * b;
        }

        return a;
    }
}