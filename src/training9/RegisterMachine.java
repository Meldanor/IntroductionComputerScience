/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training9;

public class RegisterMachine {

    private static void first(int b, int c0, int c1, int c2) {
        System.out.println(b + " " + c0 + " " + c1 + " " + c2);
        //@formatter:off
        c0 = c2;            // LOAD 2
        ++b;
        while(c0 != 0) {    // if c0 = 0 GOTO 10
            ++b;
            c0 = c1;        // LOAD 1
            ++b;
            ++c0;           // CADD 1
            ++b;
            c1 = c0;        // STORE 1
            ++b;
            c0 = c2;        // LOAD 2
            ++b;
            --c0;           // CSUB 1
            ++b;
            c2 = c0;        // STORE 2
            ++b;
        }
        //@formatter:on
        System.out.println(b + " " + c0 + " " + c1 + " " + c2);
    }

    private static void second(int b, int c0, int c1, int c2) {

        System.out.println(b + " " + c0 + " " + c1 + " " + c2);
        //@formatter:off
        c0 = c2;            //LOAD 2
        ++b;
        c0 -= 5;            //CSUB 5
        ++b;
        if (c0 == 0) {      //if c0 = 0 GOTO 8
            ++b;
            c0 = c2;        //LOAD 2
            ++b;
            c0 += c1;       //ADD 1
            ++b;
            c1 = c0;        //STORE 1
            ++b;
        }
        else {              
            ++b;
            c0 = c2;        //LOAD 2
            ++b;
            c0 *= c1;       //MULT 1
            ++b;
            c1 = c0;        //STORE 1
            ++b;
        }
        //@formatter:on
        System.out.println(b + " " + c0 + " " + c1 + " " + c2);
    }

    public static void test() {
        first(1, 0, 5, 2);
        System.out.println();
        second(1, 0, 7, 4);
        System.out.println();
        second(1, 0, 7, 6);
        System.out.println();
        second(1, 1, 5, 5);
        System.out.println();
        second(1, 0, 5, 5);
    }

}
