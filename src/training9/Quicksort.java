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

public class Quicksort {
    //@formatter:off
    /*
     * 5 3 4 8 7 1 2
     * ^         ^   | pivot is "2"
     * i         j   
     * 
     * Increment i when a[i] < 2
     * 5 < 2 -> false
     * Decrement j when a[j] > 2
     * 1 > 2 -> false
     * Swap a[i] and a[j]
     * 
     * 1 3 4 8 7 5 2
     * ^         ^   | pivot is "2"
     * i         j   
     * 
     * Increment i when a[i] < 2
     * 1 < 2
     * 
     * 1 3 4 8 7 5 2
     *   ^       ^   | pivot is "2"
     *   i       j   
     * 3 < 2 -> false
     * Decrement j when a[j] > 2
     * 5 > 2
     * 
     * 1 3 4 8 7 5 2
     *   ^     ^     | pivot is "2"
     *   i     j
     * ... as long i < j
     * 
     * 1 3 4 8 7 5 2
     * ^ ^           | pivot is "2"
     * j i      
     * 1 > 2 -> false
     * Swap a[i] and a[j]
     * 3 1 4 8 7 5 2
     * ^ ^           | pivot is "2"
     * j i
     * 
     * Swap a[i] and a[j]
     * 
     * 1 3 4 8 7 5 2
     * ^ ^           | pivot is "2"
     * j i
     * 
     * Swap a[i] and pivot
     * 
     * 1 2 4 8 7 5 3
     * ^ ^           | pivot is "2"
     * j i
     * 
     * -> Curse of Recursion with old left border(0) and right border is position of i - 1 (0)
     * 
     * 1 2 4 8 7 5 3
     * ^             | pivot is "2"
     * i 
     * j
     * 
     * -> r > l -> false, so don't do this way
     * 
     * -> Curse of Recursion with left border = i +1 (2) and old right border (6)
     * 1 2 4 8 7 5 3
     *     ^     ^   | pivot is "3"
     *     i     j 
     * 
     * Increment i when a[i] < 3
     * 4 < 3 -> false
     * Decrement j when a[j] > 3
     * 5 > 3
     * 1 2 4 8 7 5 3
     *     ^   ^     | pivot is "3"
     *     i   j   
     * ...
     * 1 2 4 8 7 5 3
     *   ^ ^         | pivot is "3"
     *   j i    
     * 
     * 2 > 3 -> false
     * Swap a[i] and a[j]
     * 1 4 2 8 7 5 3
     *   ^ ^         | pivot is "3"
     *   j i    
     * 
     * Swap a[j] and a[i]
     * 1 2 4 8 7 5 3
     *   ^ ^         | pivot is "3"
     *   j i
     * Swap [i] and pivot
     * 1 2 3 8 7 5 4
     *   ^ ^         | pivot is "3"
     *   j i
     * ...
     * 
     * 1 2 3 4 5 7 8
     * 
     * Worst case:
     * 
     * 1 2 3 4 5 6 7 8
     * Pivot = 1
     * -> have to swap everything and create new recursions just for one swap!
     * O(n²)
     * 
     * Average case:
     * O ((n-1)/2)
     * 
     * Best case:
     * Sublists are equal 
     * O (n * ln n)
     * 
     * Randomized array of times in 24h format
     * [14:57, 12:16, 16:41, 20:13, 02:01, 00:41, 05:05, 22:40, 03:45, 17:34, 08:06, 12:56, 21:21, 07:18, 07:16, 12:03, 06:40, 04:14, 18:02, 19:35]
     * Sorted with quicksort
     * [00:41, 02:01, 03:45, 04:14, 05:05, 06:40, 07:16, 07:18, 08:06, 12:03, 12:16, 12:56, 14:57, 16:41, 17:34, 18:02, 19:35, 20:13, 21:21, 22:40]
     */
    
    //@formatter:on

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
        T p = a[r], temp; // pivot

        int i = l, j = r - 1;
        do {
            while (a[i].compareTo(p) < 0)
                ++i; // find
            while (j > 0 && a[j].compareTo(p) > 0)
                --j;
            temp = a[i];
            a[i] = a[j];
            a[j] = temp; // swap
        }
        while (i < j);

        a[j] = a[i];
        a[i] = a[r];
        a[r] = temp;
        return i; // new index of pivot
    }

    public static void test() {
//        Random rand = new Random();
//        Time[] times = new Time[20];
//        for (int i = 0; i < times.length; ++i)
//            times[i] = new Time(rand.nextInt(24), rand.nextInt(60));
//        System.out.println(Arrays.toString(times));
//        quickSort(times);
//        System.out.println(Arrays.toString(times));
    }
}
