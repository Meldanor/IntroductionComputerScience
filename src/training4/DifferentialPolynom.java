/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training4;

import java.util.Arrays;

public class DifferentialPolynom {

    public static double[] diffPoly(double[] coeffs, int nDiffs) {

        double[] result = coeffs;

        for (int i = 1; i <= nDiffs; ++i) {
            result = Arrays.copyOfRange(result, 1, result.length);
            for (int j = 0; j < result.length; ++j) {
                result[j] = result[j] * (j + 1);
            }
        }

        return result;

    }

    public static double intPoly(double[] coeffs, double x0, double x1) {

        double[] integral = new double[coeffs.length + 1];

        integral[0] = 0;
        for (int i = 1; i < integral.length; ++i)
            integral[i] = coeffs[i - 1] * (1.0 / i);
        System.out.println(polyToString(integral));

        return evalHorner(integral, x1) - evalHorner(integral, x0);
    }

    public static double evalHorner(double[] a, double x) {
        double result = 0;
        for (int i = a.length - 1; i >= 0; --i)
            result = a[i] + (x * result);
        return result;

    }

    public static void test() {

        double[] a = { 1, 2, 3, 4, 5 };
         System.out.println(polyToString(a));
         System.out.println(polyToString(diffPoly(a, 2)));

        a = new double[] { 8, 5, 6 };
        System.out.println(intPoly(a, 0, 1));
    }

    private static String polyToString(double[] a) {

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(a[0]);
        sBuilder.append(" + ");
        for (int i = 1; i < a.length; ++i) {
            sBuilder.append(a[i]);
            sBuilder.append("x^");
            sBuilder.append(i);
            sBuilder.append(" + ");
        }

        return sBuilder.toString().substring(0, sBuilder.length() - 3);
    }
}
