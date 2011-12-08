/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training8;

public class TernarySearch {
    static final int UNDEF = -1;

    public static int find(int[] a, int x) {
        return _find(a, 0, a.length - 1, x);
    }

    private static int _find(int[] a, int l, int r, int x) {
        if (l > r)
            return UNDEF;
        int m = (l + r) / 2;
        if (x == a[m])
            return m;
        else if (x < a[m])
            return _find(a, l, m - 1, x);
        else
            return _find(a, m + 1, r, x);
    }

    public static int ternaryRec(int a[], int x) {
        return ternaryRec(a, 0, a.length / 2, a.length - 1, x);

    }

    private static int ternaryRec(int[] a, int l, int m, int r, int x) {
        if (l > r)
            return UNDEF;
        int n = (l + r + m) / 3;
        if (x == a[n])
            return n;
        if (x == a[2 * n])
            return 2 * n;
        if (x < a[n])
            return ternaryRec(a, l, n / 2, n, x);
        else if (x > a[m] && x < a[2 * n])
            return ternaryRec(a, n / 2, n, r, x);
        else
            return ternaryRec(a, n, 2 * n, r, x);
    }

    public static void main(String[] args) {
        // TODO: test-datas

    }
}
