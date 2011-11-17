/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training4;

import java.util.Arrays;
import java.util.Random;

public class Food implements Comparable<Food> {

    private static String[] TYPES = { "Apple", "Pear", "Cookie" };

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

    @Override
    public String toString() {
        return "A " + type + " having " + calories + " calories";
    }

    public static Food[] createSortedRandomList(int n) {

        Random rand = new Random();
        Food[] foods = new Food[n];

        for (int i = 0; i < n; ++i)
            foods[i] = new Food(TYPES[rand.nextInt(3)], rand.nextInt(1294) + 42);

        Arrays.sort(foods);
        return foods;
    }

    public static void test() {

        System.out.println(Arrays.toString(createSortedRandomList(10)));
        System.out.println(Arrays.toString(createSortedRandomList(30)));
        System.out.println(Arrays.toString(createSortedRandomList(5)));

        Food[] a = { new Food("Apple", 50), new Food("Pear", 49),
                new Food("Apple", 49) };
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
