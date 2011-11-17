/*
 * Copyright (C) 2011 Kilian Gaertner
 * 
 * Dieser Quelltext ist Open Source und kann von jedem verwendet werden, der 
 * folgende Bedingung einhält:
 * Jeder, der den Quelltext, ob in Teilen oder komplett, muss dem Inhabenden
 * des Copyrights eine Pizza spendieren, sollte derjenige dem Inhabenden des Copyrights
 * begegnen.
 */

package training2;

public class NPalindrome {

    public static int numDigits(int n) {
        return Integer.toString(n).length();
    }

    public static int getDigit(int n, int index) {
        if (n < 0)
            return 0;
        
        String number = Integer.toString(n);
        if (index >= number.length())
            index = number.length() -1 ;
        
        return Character.getNumericValue(number.charAt(index));
    }

    public static boolean isPalindrome(int n) {
        char[] array = Integer.toString(n).toCharArray();
        
        for(int i = 0 ; i < (array.length / 2) ; ++i)
            if (array[i] != array[array.length-i-1])
                return false;

        return true;
    }

    public static void test() {
        System.out.println(numDigits(100));
        System.out.println(getDigit(126,3));
        System.out.println(isPalindrome(1331));
        System.out.println(isPalindrome(13331));
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(3210));
    }
}
