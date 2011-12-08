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

public class RestClass implements Solid {

    private int repre = 0;
    private int m = 0;

    public RestClass(int representative, int m) {
        this.repre = representative % m;
        if (!isPrime(m))
            throw new RuntimeException("The base m=" + m + " is not a prime!");
        if (repre < 0)
            repre += m;
        this.m = m;
    }

    public int getRepresentative() {
        return repre;
    }

    public int getM() {
        return m;
    }

    public Solid add(Solid s) {
        if (!(s instanceof RestClass))
            throw new RuntimeException(this.getClass().getName()
                    + "expected, but it was " + s.getClass().getName());
        RestClass rc = (RestClass) s;
        if (this.m != rc.getM())
            throw new RuntimeException("This has the base m=" + m
                    + ", but the other base was m'=" + rc.getM());

        return new RestClass(this.repre + rc.getRepresentative(), this.m);
    }

    public Solid mult(Solid s) {
        if (!(s instanceof RestClass))
            throw new RuntimeException(this.getClass().getName()
                    + "expected, but it was " + s.getClass().getName());

        RestClass rc = (RestClass) s;
        if (this.m != rc.getM())
            throw new RuntimeException("This has the base m=" + m
                    + ", but the other base was m'=" + rc.getM());

        return new RestClass(this.repre * rc.getRepresentative(), this.m);
    }

    public Solid getMultInverse() {
        for (int i = 1; i < m; ++i)
            if (repre * i % m == 1)
                return new RestClass(i, m);

        // Just impossible -> a black hole will open and destroy everthing!
        return null;

    }

    public Solid getAddInverse() {
        return new RestClass((repre * -1), m);
    }

    public boolean isOneElement() {
        return repre == 1;
    }

    public boolean isZeroElement() {
        return repre == 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new RestClass(repre, m);
    }

    @Override
    public String toString() {
        return "[" + repre + "]";
    }

    private boolean isPrime(int number) {
        if (number == 2)
            return true;
        if (number == 1 || number % 2 == 0)
            return false;

        for (int i = 3; i < number / 2; i += 2)
            if (number % i == 0)
                return false;

        return true;
    }
}
