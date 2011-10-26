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
            // System.out.println(isPerfectNumber(8128));
            try {
                long time = System.currentTimeMillis();
                System.out.println(bigTest() + " in "
                        + (System.currentTimeMillis() - time));
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean bigTest() throws Exception {

        BufferedReader bReader = new BufferedReader(new FileReader(
                "bin/tests.txt"));
        String line = "";
        while ((line = bReader.readLine()) != null) {
            String[] split = line.trim().split(",");
            for (String num : split) {
                num = num.trim();
                int n = Integer.parseInt(num);
                if (!isPrime(n))
                    return false;
            }

        }
        bReader.close();
        return true;
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