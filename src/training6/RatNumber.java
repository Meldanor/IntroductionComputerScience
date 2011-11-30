/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training6;

import java.util.Arrays;
import java.util.Random;

public class RatNumber implements Comparable<RatNumber> {
    private int num;
    private int denom;

    public RatNumber(int n, int d) throws RuntimeException {
        if (d == 0)
            throw new RuntimeException("divisor zero");

        if (d < 0) {
            n *= -1;
            d *= -1;
        }

        int ggt = Math.abs(ggt(n, d));

        this.num = n / ggt;
        this.denom = d / ggt;

    }

    private int ggt(int a, int b) {
        int help = 0;
        while (b != 0) {
            help = a % b;
            a = b;
            b = help;
        }
        return a;
    }

    public int getNum() {
        return num;
    }

    public int getDenom() {
        return denom;
    }

    public int compareTo(RatNumber n) {

        double r = (double) this.num / (double) this.denom;

        double r2 = (double) n.getNum() / (double) n.getDenom();

        if (r < r2)
            return -1;
        if (r > r2)
            return 1;
        return 0;
    }

    private int kgV(int a, int b) {
        return (a * b) / ggt(a, b);
    }

    public RatNumber add(RatNumber r) {

        int d1 = this.getDenom();
        int d2 = r.getDenom();
        int kgV = kgV(d1, d2);
        int n1 = this.getNum() * (kgV / d1);
        int n2 = r.getNum() * (kgV / d2);

        return new RatNumber(n1 + n2, kgV);
    }

    public RatNumber sub(RatNumber r) {
        int d1 = this.getDenom();
        int d2 = r.getDenom();
        int kgV = kgV(d1, d2);
        int n1 = this.getNum() * (kgV / d1);
        int n2 = r.getNum() * (kgV / d2);

        return new RatNumber(n1 - n2, kgV);
    }

    public RatNumber mult(RatNumber r) {

        return new RatNumber(this.getNum() * r.getNum(), this.getDenom()
                * r.getDenom());
    }

    public RatNumber div(RatNumber r) {
        return new RatNumber(this.getNum() * r.getDenom(), this.getDenom()
                * r.getNum());
    }

    public String toString() {
        if (denom == 1)
            return String.valueOf(num);

        return this.num + "/" + this.denom;
    }

    public static void test() {
        RatNumber r1 = new RatNumber(1, 2);
        RatNumber r2 = new RatNumber(1, 4);

        // 1
        System.out.println(r1.add(r1));
        // 3/4
        System.out.println(r1.add(r2));
        // 0
        System.out.println(r1.sub(r1));
        // -1/4
        System.out.println(r1.sub(r2).sub(r1));
        // -1/2
        System.out.println(new RatNumber(-1, 2));
        // -1/2
        System.out.println(new RatNumber(1, -2));
        // 1/2
        System.out.println(new RatNumber(-1, -2));
        // 1/4
        System.out.println(r1.mult(r1));
        // 1/2
        System.out.println(r1.mult(r1).div(r1));

        RatNumber[] numbers = new RatNumber[10];
        Random rand = new Random();

        // generate numbers from -10 to 9
        for (int i = 0; i < numbers.length; ++i)
            numbers[i] = new RatNumber(rand.nextInt(10) * (rand.nextBoolean() ? 1 : -1), rand.nextInt(10) + 1);

        // Example: [1/3, 7, 7/2, 2/7, 3/5, 2, 4/9, 6, 3/8, 2/9]
        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers);
        // Sorted: [2/9, 2/7, 1/3, 3/8, 4/9, 3/5, 2, 7/2, 6, 7]
        System.out.println(Arrays.toString(numbers));
    }
}
