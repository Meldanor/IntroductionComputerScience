import training7.gauss.Solid;

/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett,nutzt, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // new Training1().test();
        // Training3.test();
        // Training4.test();
        // Training5.test();
        // Training6.test();
        // Training7.test();
        // System.out.println(-1260 % 1440);

        //@formatter:off
        int[][] test = new int[][]{
                {
                    5 , 5 , 5, 5, 5
                },
                {
                    0 , 1 , 5, 5, 5
                },
                {
                    0 , 1 , 2, 5, 5
                },
                {
                    0 , 0 , 0, 1, 5
                },
                {
                    0 , 0 , 0, 0, 4
                }
        };
        //@formatter:on

        for (int i = 0; i < test.length; ++i) {
            System.out.println(test[i][0]);
            // for (int j = 0; j < test[i].length; ++j)

        }
    }

}
