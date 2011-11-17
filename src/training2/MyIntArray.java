/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training2;

import java.util.Random;

public class MyIntArray {

    public static int[] create(int n) {
        Random rand = new Random();
        int[] array = new int[n];
        for (int i = 0; i < array.length; ++i)
            array[i] = rand.nextInt(95) + 5;
        return array;
    }

    public static String toString(int[] a) {

        StringBuilder sBuilder = new StringBuilder("");
        for (int i = 0; i < a.length; ++i)
            sBuilder.append(a[i]);
        return sBuilder.toString();
    }

    public static int posMin(int[] a) {
        if (a.length == 0)
            return Integer.MIN_VALUE;
        int min = a[0];
        int index = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] < min) {
                index = i;
                min = a[i];
            }
        }
        return index;
    }

    public static int specialSum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; ++i) {
            if (a[i] % 4 == 0 || a[i] % 13 == 0)
                continue;
            sum += a[i];
        }
        return sum;
    }

    public static void test() {
        System.out.println(posMin(new int[] { 4, 5, 6, 1, 2, 3 }));
    }
}
