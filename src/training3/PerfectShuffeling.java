package training3;

import java.util.Arrays;

public class PerfectShuffeling {

    public static int[] interleave(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        for (int i = 0, j = 0; j < a.length; ++i, ++j) {
            result[i] = a[j];
            ++i;
            result[i] = b[j];
        }
        return result;
    }

    public static int[] shuffle(int[] a) {
        // split the array into the half -> faster than coping it with a loop
        // because it is native implemented
        return interleave(Arrays.copyOfRange(a, 0, a.length / 2),
                Arrays.copyOfRange(a, a.length / 2, a.length));
    }

    public static int shuffleNumber(int n) {
        // create deck
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = i + 1;

        int[] b = a;
        int counter = 0;

        // shuffle as long as the origin arrays isn't reached
        do {
            b = shuffle(b);
            ++counter;
        }
        while (!areEqual(a, b));

        return counter;
    }

    private static boolean areEqual(int[] a, int[] b) {
        for (int i = 0; i < a.length; ++i)
            if (a[i] != b[i])
                return false;
        return true;
    }

    public static void test() {
        int[] a = { 1, 2, 3 };
        int[] b = { 4, 5, 6 };

        System.out.println(Arrays.toString(interleave(a, b)));
        int[] c = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(Arrays.toString(shuffle(c)));

        System.out.println(shuffleNumber(58));
    }
}
