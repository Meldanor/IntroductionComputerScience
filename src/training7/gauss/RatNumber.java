/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training7.gauss;

public class RatNumber implements Comparable<RatNumber>, Solid {
    private final int num;
    private final int denom;

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
        return ((RatNumber) this.sub(n)).getNum();
    }

    private int kgV(int a, int b) {
        int ggt = ggt(a, b);
        return (a / ggt) * (b / ggt);
    }

    @Override
    public String toString() {
        if (denom == 1)
            return String.valueOf(num);

        return this.num + "/" + this.denom;
    }

    public Solid add(Solid s) {
        if (!(s instanceof RatNumber))
            throw new RuntimeException(this.getClass().getName()
                    + "expected, but it was " + s.getClass().getName());

        RatNumber r = (RatNumber) s;
        int d1 = this.getDenom();
        int d2 = r.getDenom();
        int kgV = kgV(d1, d2);
        int n1 = this.getNum() * (kgV / d1);
        int n2 = r.getNum() * (kgV / d2);

        return new RatNumber(n1 + n2, kgV);
    }

    public Solid sub(Solid s) {
        if (!(s instanceof RatNumber))
            throw new RuntimeException(this.getClass().getName()
                    + "expected, but it was " + s.getClass().getName());

        RatNumber r = (RatNumber) s;
        int d1 = this.getDenom();
        int d2 = r.getDenom();
        int kgV = kgV(d1, d2);
        int n1 = this.getNum() * (kgV / d1);
        int n2 = r.getNum() * (kgV / d2);

        return new RatNumber(n1 - n2, kgV);
    }

    public Solid mult(Solid s) {
        if (!(s instanceof RatNumber))
            throw new RuntimeException(this.getClass().getName()
                    + "expected, but it was " + s.getClass().getName());

        RatNumber r = (RatNumber) s;
        return new RatNumber(this.getNum() * r.getNum(), this.getDenom()
                * r.getDenom());
    }

    public Solid div(Solid s) {
        if (!(s instanceof RatNumber))
            throw new RuntimeException(this.getClass().getName()
                    + "expected, but it was " + s.getClass().getName());

        RatNumber r = (RatNumber) s;
        return new RatNumber(this.getNum() * r.getDenom(), this.getDenom()
                * r.getNum());
    }

    @Override
    public Solid getMultInverse() {
        return new RatNumber(getDenom(), getNum());
    }

    @Override
    public boolean isOneElement() {
        return num == 0;
    }

    @Override
    public boolean isZeroElement() {
        return denom == num;
    }

    public Solid getAddInverse() {
        return new RatNumber(getNum() * -1, getDenom());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new RatNumber(num, denom);
    }

}
