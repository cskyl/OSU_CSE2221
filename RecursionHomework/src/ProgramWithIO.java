import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ProgramWithIO {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramWithIO() {
    }

    /**
     * Returns the number of digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to count
     * @return the number of digits of {@code n}
     * @ensures numberOfDigits = [number of digits of n]
     */
    private static int numberOfDigits(NaturalNumber n) {
        int temp = 0;
        int number = 0;
        if (!n.isZero()) {
            n.divideBy10();
            number++;
            temp = numberOfDigits(n);
            number += temp;
        }

        return number;
    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static int sumOfDigits(NaturalNumber n) {
        int temp1 = 0;
        int temp2 = 0;
        int sum = 0;

        if (!n.isZero()) {
            temp1 = n.divideBy10();
            temp2 = sumOfDigits(n);
            sum = temp1 + temp2;
        }

        return sum;

    }

    /**
     * Returns the sum of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to add
     * @return the sum of the digits of {@code n}
     * @ensures sumOfDigits = [sum of the digits of n]
     */
    private static NaturalNumber sumOfDigits2(NaturalNumber n) {
        NaturalNumber temp1 = new NaturalNumber2(0);
        NaturalNumber temp2 = new NaturalNumber2(0);
        NaturalNumber sum = new NaturalNumber2(0);

        if (!n.isZero()) {
            temp1 = new NaturalNumber2(n.divideBy10());
            temp2 = sumOfDigits2(n);
            sum.add(temp2);
            sum.add(temp1);
        }

        return sum;
    }

    /**
     * Divides {@code n} by 2.
     *
     * @param n
     *            {@code NaturalNumber} to be divided
     * @updates n
     * @ensures 2 * n <= #n < 2 * (n + 1)
     */
    private static void divideBy2(NaturalNumber n) {
        int remainder = n.divideBy10();
        int remainder2 = n.divideBy10();
        if (!n.isZero()) {
            n.multiplyBy10(remainder2);
            divideBy2(n);
            n.multiplyBy10(remainder / 2);

        } else {
            remainder = remainder / 2;
            int half = (remainder2 * 5 + remainder);
            n.multiplyBy10(half / 10);
            n.multiplyBy10(half % 10);
        }
    }

    /**
     * Checks whether a {@code String} is a palindrome.
     *
     * @param s
     *            {@code String} to be checked
     * @return true if {@code s} is a palindrome, false otherwise
     * @ensures isPalindrome = (s = rev(s))
     */
    private static boolean isPalindrome(String s) {
        boolean isP = true;
        boolean temp = true;
        char left = 0;
        char right = 0;
        if (s.length() > 2 && isP == true) {
            left = s.charAt(0);
            right = s.charAt(s.length() - 1);
            s = s.substring(1, s.length() - 1);
            isP = isPalindrome(s);
        }
        if (isP && left != right) {
            isP = false;
        }
        return isP;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        NaturalNumber n = new NaturalNumber2(321);
        NaturalNumber sum1 = new NaturalNumber2();
        int num, sum;
        boolean isP;
        String s = "aaaabbb";

        num = numberOfDigits(n);
        n.copyFrom(new NaturalNumber2(321));
        sum = sumOfDigits(n);
        n.copyFrom(new NaturalNumber2(321));
        sum1 = sumOfDigits2(n);
        n.copyFrom(new NaturalNumber2(321));
        divideBy2(n);

        isP = isPalindrome(s);

        out.println("number of digits = " + num);
        out.println("sum of digits = " + sum);
        out.println("sum of digits = " + sum1.toString());
        out.println(s + " is palindrone = " + isP);
        out.println(n.toString());
        in.close();
        out.close();
    }

}
