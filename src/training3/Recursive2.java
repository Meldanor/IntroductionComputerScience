package training3;

public class Recursive2 {

    /**
     * Berechnet das Quadrat der Zahl. Terminiert nicht, wenn n <= 0 gilt...
     */

    public static int f(int n) {
        if (n == 1)
            return 1;
        else
            return f(n - 1) + (2 * n) - 1;
    }

    /*
     * Fuer f(4,2)
     * ->
     * if (2 == 0) -> false
     * else if (4 < 2*2) -> false
     * else
     *  -> 4 * f(3,1) / 2
     *  f (3,1) ->
     *  if (1 == 0) -> false
     *  else if (3 < 2) -> false
     *  else
     *      -> 3 * f(2,0) / 1
     *      f(2,0) ->
     *      if (0 == 0) -> true, return 1 
     *      -> f(2,0) == 1 
     *          -> f(3,1) return 3 * 1 / 1 = 3
     *              -> f(4,2) return 4 * 3 / 2 = 6
     *              
     * Fuer(8,5) ->
     * if (5 == 0 ) = false
     * else if (8 < 10) 
     *  -> f(8,8-5)
     *      if (3 == 0) = false
     *      else if (8 < 3*2) = false
     *      else = 8 * (7,2) / 3
     *      f(7,2)
     *          if (2 == 0) = false
     *          else if (7 < 2*2) = false
     *          else = 7 * (6,1) / 2
     *          f(6,1)
     *              if(1 == 0) = false
     *              else if (6 < 2) = false
     *              else = 6 * (5,0) / 2
     *              f(5,0)
     *              if (0==0) = true, return 1
 *              = 6 * 1 / 1 = 6
 *          = 7 * 6 / 2 = 24
 *      f(8,5)   = 8 * 24 / 3 = 56
     */
    public static int g(int x, int y) {
        if (y == 0)
            return 1;
        else if (x < 2 * y)
            return g(x, x - y);
        else
            return x * g(x - 1, y - 1) / y;
    }

    public static void test() {

        System.out.println(g(4, 2));
        System.out.println(g(8, 5));
        //
        // for (int i = 1; i <= 50; ++i)
        // System.out.println("i= " + i + " -> " + f(i));
    }
}
