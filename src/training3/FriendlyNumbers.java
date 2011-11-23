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

public class FriendlyNumbers {

    public static int[][] amicablePairs(int n) {
        int[][] result = new int[n][2];
        int counter = 0;
        int number = 0;
        int sum = 0;
        out: while (counter < n) {
            ++number;
            sum = getDivisorSum(number);
            if (getDivisorSum(sum) == number && sum != number) {
                for (int i = 0; i < result.length; ++i) {
                    if (number >= sum)
                        continue out;
                }
                result[counter][0] = number;
                result[counter][1] = sum;
                ++counter;
            }
        }
        return result;
    }
//
//    private static int getTeilerSum(int number) {
//        int sum = 1;
//        int border = (number / 2) + 1;
//        for (int i = 2; i < border; ++i)
//            if (number % i == 0)
//                sum += i;
//
//        return sum;
//    }

    public static int getDivisorSum(int n) {
        
        int sum = 1;
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                sum += i + n /i;
                if (n / i == i)
                    sum -= i;
            }
            ++i;
        }
        return sum;
    }
    
    public static void test() {

        int[][] result = amicablePairs(50);
        for (int[] array : result)
            System.out.println(array[0] + "," + array[1]);
    }
}
