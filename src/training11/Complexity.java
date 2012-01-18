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

public class Complexity {

    private static final int LOGA = 0;
    private static final int LINEAR = 1;
    private static final int LINEAR_LOGA = 2;
    private static final int SQUARE = 3;
    private static final int CUBOID = 4;
    private static final int EXPO = 5;

    private static final double LOG_RESULT = Math.log(2.0);

    private static final double MICRO = 1000.0;
    private static final double MILLI = 1000.0;
    private static final double SEC = 1000.0;
    private static final double MIN = 60.0;
    private static final double HOUR = 60.0;
    private static final double DAY = 24.0;
    private static final double YEAR = 365.0;
    private static final double YEAR_K = 1000.0;
    private static final double YEAR_M = 1000.0;

    public static void test() {
        System.out.println("n\tld n\tn\tn*ld n\tn^2\tn^3\t2^n");
        System.out
                .println("---------------------------------------------------");
        for (int k = 1; k <= 9; ++k) {

            System.out.print((int) Math.pow(2, k) + "\t");
            for (int i = 0; i < 6; ++i)
                System.out.print(trimTime(calculateTime(Math.pow(2, k), i))
                        + "\t");
            System.out.println();
        }
    }

    private static double calculateTime(double n, int algo) {
        switch (algo) {
            case LOGA:
                return Math.round(Math.log(n) / LOG_RESULT);
            case LINEAR:
                return n;
            case LINEAR_LOGA:
                return Math.round(n * (Math.log(n) / LOG_RESULT));
            case SQUARE:
                return n * n;
            case CUBOID:
                return n * n * n;
            case EXPO:
                return Math.pow(2, n);
            default:
                throw new IllegalArgumentException("Unknown algorithm id "
                        + algo);
        }
    }

    private static String trimTime(double time) {
        if (time == Double.MAX_VALUE)
            return "Chuck Norris know";
        double div = 1.0;
        String unit = "ns";
        if (time > MICRO) {
            div *= MICRO;
            unit = "mcs";
        }
        if (time > MICRO * MILLI) {
            div *= MILLI;
            unit = "ms";
        }
        if (time > MICRO * MILLI * SEC) {
            div *= SEC;
            unit = "s";
        }
        if (time > MICRO * MILLI * SEC * MIN) {
            div *= MIN;
            unit = "m";
        }
        if (time > MICRO * MILLI * SEC * MIN * HOUR) {
            div *= HOUR;
            unit = "h";
        }
        if (time > MICRO * MILLI * SEC * MIN * HOUR * DAY) {
            div *= DAY;
            unit = "d";
        }
        if (time > MICRO * MILLI * SEC * MIN * HOUR * DAY * YEAR) {
            div *= YEAR;
            unit = "a";
        }
        if (time > MICRO * MILLI * SEC * MIN * HOUR * DAY * YEAR * YEAR_K) {
            div *= YEAR_K;
            unit = "ka";
        }
        if (time > MICRO * MILLI * SEC * MIN * HOUR * DAY * YEAR * YEAR_K * YEAR_M) {
            div *= YEAR_M;
            unit = "ma";
        }
        return (time / div) + unit;
    }
}
