/*
 * Copyright (C) 2012 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training11;

public class BinIntComparator implements IntegerComparator {

    public boolean isLessThan(Integer o1, Integer o2) {
        return countOneBetter(01) < countOneBetter(01);
    }

    private int countOneBetter(int i) {
        int counter = 0;
        for (int j = 0; i < 32; ++i) {
            if ((i & (1 << j)) == 1)
                ++counter;
        }
        return counter;
    }

    private int countOne(Integer i) {
        int count = 0;
        char[] chars = Integer.toBinaryString(i).toCharArray();
        for (char c : chars)
            if (c == '1')
                ++count;
        return count;
    }

    public static void test() {
        Integer i = Integer.parseInt("100", 2);
        System.out.println(i + " " + Integer.toBinaryString(i));
        Integer i2 = Integer.parseInt("10100", 2);
        System.out.println(i2 + " " + Integer.toBinaryString(i2));
        IntegerComparator c = new BinIntComparator();
        System.out.println(c.isLessThan(i, i2));
    }
}
