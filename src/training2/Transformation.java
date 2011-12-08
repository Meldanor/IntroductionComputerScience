/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training2;

public class Transformation {

    public static void test() {
//        System.out.println("Test for number = 2500:");
//        for (int i = 2; i <= 16; ++i)
//            System.out.println("Base '" + i + "': " + transform(2500, i));
//
//        System.out.println();
//        System.out.println("Test for number = 1337:");
//        for (int i = 2; i <= 16; ++i)
//            System.out.println("Base '" + i + "': " + transform(1337, i));
//
//        System.out.println();
//        System.out.println("Test for number = 42:");
//        for (int i = 2; i <= 16; ++i)
//            System.out.println("Base '" + i + "': " + transform(42, i));
    }

    public static String transform(int dez, int basis) {

        if (basis == 10)
            return Integer.toString(dez);

        StringBuilder sBuilder = new StringBuilder();
        int rest = 0;
        while (dez > 0) {
            rest = dez % basis;
            dez = dez / basis;
            sBuilder.append(getCharForNumber(rest, basis));
        }
        return sBuilder.reverse().toString();
    }

    private static String getCharForNumber(int number, int basis) {
        if (number == basis)
            return Integer.toString(0);
        if (number < 10)
            return Integer.toString(number);
        else {
            switch (number) {
                case 10:
                    return "a";
                case 11:
                    return "b";
                case 12:
                    return "c";
                case 13:
                    return "d";
                case 14:
                    return "e";
                case 15:
                    return "f";
                default:
                    return "Fail";
            }
        }
    }
}
