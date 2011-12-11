/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training7;

import training7.gauss.Gauss;
import training7.gauss.RatNumber;

public class Training7 {

    public static void test() {
        // FastPot.test();
        // LittleFermat.test();
        gauss();
    }

    private static void gauss() {
        //@formatter:off
        int[][] test = {
            {
                1, 1 , 1, 0
            },
            {
                4 , 2 , 1, 5
            },
            {
                9 , 3 , 1, 3
            }
        };
        //formatter:on
        
        RatNumber[][] matrix = new RatNumber[test.length][];
        for (int i = 0 ; i < test.length ; ++i) {
            matrix[i] = new RatNumber[test[i].length];
            for (int j = 0 ; j < test[i].length ; ++j)
                matrix[i][j] = new RatNumber(test[i][j]);
        }
        
        Gauss g = new Gauss(matrix);
        System.out.println(g.originalToString());
        g.solve();
        System.out.println(g.resultToString());
        
    }
}
