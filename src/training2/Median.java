package training2;

import java.util.Arrays;

public class Median {
    public static int median(int a, int b, int c) {

        if (a < b) {
            if (b < c)
                return b;
            else {
                if (a < c)
                    return c;
                else
                    return a;
            }
        }
        else if (b < c) {
            if (a < c)
                return a;
            else
                return c;
        }
        else
            return b;

    }

    public static int median2(int a, int b, int c) {

        int[] t = { a, b, c };
        // use quicksort for sorting the array ascending
        Arrays.sort(t);
        return t[1];
    }

    public static double medianCommon(int... t) {

        // use quicksort for sorting the array ascending
        Arrays.sort(t);
        if (t.length % 2 == 0) {
            int index = t.length / 2;
            return (t[index - 1] + t[index]) / 2.0;
        }
        else
            return t[t.length / 2];
    }
    
    public static void test() {

        
        System.out.println(median(11, 25, 33));
        System.out.println(median(25, 11, 33));
       
        System.out.println(median(25, 33, 11));
        System.out.println(median(11, 33, 25));
       
        System.out.println(median(33, 11, 25));
        System.out.println(median(33, 25, 11));
       
        System.out.println();
       
        System.out.println(median2(11, 25, 33));
        System.out.println(median2(25, 11, 33));
       
        System.out.println(median2(25, 33, 11));
        System.out.println(median2(11, 33, 25));
       
        System.out.println(median2(33, 11, 25));
        System.out.println(median2(33, 25, 11));
       
       System.out.println(medianCommon(3, 2, 1, 4, 5, 6));
       System.out.println(medianCommon(1, 2, 3, 4, 5, 6));
    }
}
