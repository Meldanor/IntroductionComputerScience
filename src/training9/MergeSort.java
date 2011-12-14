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
import java.util.Comparator;

public class MergeSort {
    
    /*
     * 5, 3, 4, 7, 1, 2
     *     /     \
     * 5,3,4     7,1,2
     *  / \       / \
     * 5  3,4    7   1,2
     * |   / \   |   / \
     * 5  3  4   7  1   2
     * |  \  /   |   \ /
     * 5   3,4   7   1,2
     *  \  /      \   /
     *  3,4,5       1,2,7
     *       \     /
     *     1,2,3,4,5,7
     * a) divide&conquer = minimize your problem and solve it. With that solution solve the bigger problems
     * b) Use only one array with different positions and work in-place
     */
    
    private static <T> void msort(T[] array, T[] copy, int l, int r,
            Comparator<T> c) {
        int i, j, k;

        if (r > l) {
            // zu sortierendes Feld teilen
            int mid = (r + l) / 2;

            // Teilfelder sortieren
            msort(array, copy, l, mid, c);
            msort(array, copy, mid + 1, r, c);

            // Ergebnisse mischen über Hilfsfeld b
            for (i = mid + 1; i > l; i--)
                copy[i - 1] = array[i - 1];
            for (j = mid; j < r; j++)
                copy[r + mid - j] = array[j + 1];

            for (k = l; k <= r; k++) {
                if (c.compare(copy[i], copy[j]) < 0)
                    array[k] = copy[i++];
                else
                    array[k] = copy[j--];
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> void mergeSort(T[] a, Comparator<T> c) {
        msort(a, (T[]) new Object[a.length], 0, a.length - 1, c);
    }

    public static void test() {
        String[] surnames2010 = { "Leon", "Lucas", "Lukas", "Ben", "Finn",
                "Fynn", "Jonas", "Paul", "Luis", "Louis", "Maximilian", "Luca",
                "Luka", "Felix", "Tim", "Timm", "Elias", "Max", "Noah",
                "Philip", "Philipp", "Niclas", "Niklas", "Julian", "Moritz",
                "Jan", "David", "Fabian", "Alexander", "Simon", "Jannik",
                "Yannik", "Yannick", "Yannic", "Tom" };
        Comparator<String> asc = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(Arrays.toString(surnames2010));
        mergeSort(surnames2010, asc);
        System.out.println(Arrays.toString(surnames2010));
        System.out.println();

        surnames2010 = new String[] { "Leon", "Lucas", "Lukas", "Ben", "Finn",
                "Fynn", "Jonas", "Paul", "Luis", "Louis", "Maximilian", "Luca",
                "Luka", "Felix", "Tim", "Timm", "Elias", "Max", "Noah",
                "Philip", "Philipp", "Niclas", "Niklas", "Julian", "Moritz",
                "Jan", "David", "Fabian", "Alexander", "Simon", "Jannik",
                "Yannik", "Yannick", "Yannic", "Tom" };
        Comparator<String> desc = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };
        System.out.println(Arrays.toString(surnames2010));
        mergeSort(surnames2010, desc);
        System.out.println(Arrays.toString(surnames2010));
    }
}