/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training6;

public class RatNumber implements Comparable<RatNumber> {
    private int num;
    private int denom;

    public RatNumber(int n, int d) throws RuntimeException {
        if (d == 0)
            throw new RuntimeException("divisor zero");

        if (n < 0 && d < 0) {
            n = Math.abs(n);
            d = Math.abs(d);
        }
        else if (n > 0 && d < 0) {
            n *= -1;
            d *= -1;
        }

        int ggt = ggt(n, d);
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

        double r = this.num / this.denom;
        double r2 = n.getNum() / n.getDenom();

        return r > r2 ? 1 : r < r2 ? -1 : 0;
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

        return this.num + "/" + this.denom;
    }

    public static void test() {
        // TODO: test data
    }
}
