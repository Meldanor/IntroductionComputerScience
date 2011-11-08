package training4;

import java.util.Arrays;
import java.util.Random;

public class Food implements Comparable<Food> {

    private static String[] TYPES = { "Apple", "Pear", "Cookie" };

    public static void main(String[] args) {
        // TODO your test cases
    }

    private int calories;
    private String type;

    public Food(String type, int calories) {
        this.type = type;
        this.calories = calories;
    }

    public int compareTo(Food o) {

        int res1 = this.getType().length() * this.getCalories();
        int res2 = o.getType().length() * o.getCalories();
        if (res1 == res2)
            return 0;
        else if (res1 < res2)
            return -1;
        else
            return 1;
    }

    public String getType() {
        return type;
    }

    public int getCalories() {
        return calories;
    }

    public static Food[] createSortedRandomList(int n) {

        Random rand = new Random();
        Food[] foods = new Food[n];

        for (int i = 0; i < n; ++i) {
            foods[i] = new Food(TYPES[rand.nextInt(3)], rand.nextInt(1294) + 42);
        }
        Arrays.sort(foods);
        return foods;
    }
}
