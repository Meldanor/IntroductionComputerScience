/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training9;

import java.util.Arrays;
import java.util.Random;

import training5.Time;

public class Quicksort {
    public static <T extends Comparable<T>> void quickSort(T[] a) {
        quickSort(a, 0, a.length - 1);

    }

    private static <T extends Comparable<T>> void quickSort(T[] a, int l, int r) {
        if (r > l) { // [al, . . . ,ar]
            int m = partition(a, l, r); // pivot p = am
            quickSort(a, l, m - 1);
            quickSort(a, m + 1, r);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] a, int l, int r) {
        assert (l <= r);
        T p = a[r], t; // pivot

        int i = l, j = r - 1;
        do {
            while (a[i].compareTo(p) < 0)
                ++i; // find
            while (j > 0 && a[j].compareTo(p) > 0)
                --j;
            t = a[i];
            a[i] = a[j];
            a[j] = t; // swap
        }
        while (i < j);
        a[j] = a[i];
        a[i] = a[r];
        a[r] = t;
        return i; // new index of pivot
    }

    public static void test() {
        Random rand = new Random();
        Time[] times = new Time[20];
        for (int i = 0; i < times.length; ++i)
            times[i] = new Time(rand.nextInt(24), rand.nextInt(60));
        System.out.println(Arrays.toString(times));
        quickSort(times);
        System.out.println(Arrays.toString(times));
    }
}
