package training4;

public class EvalPolynom {

    public static double evalSimple(double[] a, double x) {

        double result = a[0];
//        int counter = 1;

        for (int i = 1; i < a.length; ++i/*, ++counter*/) {
            double result2 = 1;
            for (int j = 0; j < i; ++j/*, ++counter*/)
                result2 *= x;
            result += result2 * a[i];
        }
//        System.out.println(counter);
        return result;

    }

    public static double evalHorner(double[] a, double x) {
        double result = 0;
//        int counter = 0;
        for (int i = a.length - 1; i >= 0; --i/*, ++counter*/)
            result = a[i] + (x * result);
//        System.out.println(counter);
        return result;

    }

    public static double rekHorner(double[] a, double x, int pos) {
        if (pos == a.length - 1)
            return a[pos];
        else
            return a[pos] + (x * rekHorner(a, x, ++pos));

    }

    /***************************************
     * f(x) = 25 + 11x + 7x^2 -5x^3 - 4x^4 + 2x^5 x = 5 
     * -> Horner : 6 Loops
     * -> Normal : 21 Loops
     ***************************************/

    public static void test() {

        double[] array = new double[] { 25, 11, 7, -5, -4, 2 };
        System.out.println(evalHorner(array, 5));
        System.out.println(evalSimple(array, 5));
        System.out.println(rekHorner(array, 5, 0));
    }
}
