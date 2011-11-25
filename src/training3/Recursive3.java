/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training3;

/***********************************************
 * f(x) berechnet die Differenz x-10 fuer alle x >101, sonst gibt es 91 zurueck.
 * g(x) gibt immer 1 fuer alle x > 0 zurueck. Es terminiert nicht, wenn x <= 0
 * ist. h(x) gibt immer eine gerade Zahl zurueck. g(x) ruft solange h(x) auf,
 * bis x nur noch 1 ist. Dies wird erreicht, indem h(x) x mod 2 = 0 die Zahl
 * halbiert(wird so lange halbiert, bis x = 1 ist) oder aber es erzeugt zuerst
 * eine gerade Zahl und teilt dann diese durch 2 bis x= 1 ist.
 ***********************************************/
public class Recursive3 {

    public static int f(int x) {
        if (x > 100)
            return x - 10;
        else
            return f(f(x + 11));

    }

    public static int g(int x) {

        if (x == 1)
            return 1;
        else
            return g(h(x));
    }

    private static int h(int x) {
        if (x % 2 == 0)
            return x / 2;
        else
            return (3 * x) + 1;

    }

    public static void test() {
        for (int i = -200; i <= 200; ++i)
            System.out.println("i= " + i + " -> " + f(i));

        System.out.println();

        for (int i = 1; i <= 200; ++i)
            System.out.println("i= " + i + " -> " + g(i));

//        System.out.println();
//
//        for (int i = -200; i <= 200; ++i)
//            System.out.println("i= " + i + " -> " + ((3 * i) + 1));
    }
}
