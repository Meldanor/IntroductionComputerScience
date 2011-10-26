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
