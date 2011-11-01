package training3;

public class FriendlyNumbers {

    public static int[][] amicablePairs(int n) {
        int[][] result = new int[n][2];
        int counter = 0;
        int number = 0;
        int sum = 0;
        out: while (counter < n) {
            ++number;
            sum = getTeilerSum(number);
            if (getTeilerSum(sum) == number && sum != number) {
                for (int i = 0; i < result.length; ++i) {
                    if (result[i][0] == number || result[i][0] == sum) {
                        continue out;
                    }
                }
                result[counter][0] = number;
                result[counter][1] = sum;
                ++counter;
            }
        }
        return result;
    }

    private static int getTeilerSum(int number) {
        int sum = 1;
        int border = (number / 2) + 1;
        for (int i = 2; i < border; ++i)
            if (number % i == 0)
                sum += i;

        return sum;
    }

    public static void test() {

        int[][] result = amicablePairs(11);
        for (int[] array : result)
            System.out.println(array[0] + "," + array[1]);
    }
}
