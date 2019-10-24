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
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @clears n
     * @ensures productOfDigits1 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits1(NaturalNumber n) {
        NaturalNumber product = new NaturalNumber2(1);
        NaturalNumber temp1 = new NaturalNumber2();
        NaturalNumber temp2 = new NaturalNumber2();
        int remainder = 0;

        if (n.isZero()) {

        } else {
            remainder = n.divideBy10();
            temp2 = new NaturalNumber2(remainder);
            product.multiply(temp2);
            temp1 = productOfDigits1(n);
            product.multiply(temp1);
        }

        return product;
    }

    /**
     * Returns the product of the digits of {@code n}.
     *
     * @param n
     *            {@code NaturalNumber} whose digits to multiply
     * @return the product of the digits of {@code n}
     * @ensures productOfDigits2 = [product of the digits of n]
     */
    private static NaturalNumber productOfDigits2(NaturalNumber n) {
        NaturalNumber product = new NaturalNumber2(1);
        NaturalNumber temp1 = new NaturalNumber2();
        NaturalNumber temp2 = new NaturalNumber2();
        NaturalNumber temp3 = new NaturalNumber2(n);

        int remainder = 0;

        if (n.isZero()) {

        } else {
            remainder = temp3.divideBy10();
            temp2 = new NaturalNumber2(remainder);
            product.multiply(temp2);
            temp1 = productOfDigits1(temp3);
            product.multiply(temp1);
        }

        return product;

    }

    /**
     * Reports the value of {@code n} as an {@code int}, when {@code n} is small
     * enough.
     *
     * @param n
     *            the given {@code NaturalNumber}
     * @return the value
     * @requires n <= Integer.MAX_VALUE
     * @ensures toInt = n
     */
    private static int toInt(NaturalNumber n) {
        NaturalNumber temp = new NaturalNumber2(n);
        int digit[] = new int[6];
        int i = 0;
        int number = 0;
        while (!(temp.isZero())) {
            digit[i] = temp.divideBy10();
            i++;
        }

        for (i = 1; i <= digit.length; i++) {
            number += (digit[digit.length - i]
                    * Math.pow(10, digit.length - i));
        }
        return number;
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
        /*
         * Put your main program code here
         */
        /*
         * Close input and output streams
         */
        NaturalNumber x = new NaturalNumber2(23456);
        NaturalNumber product = new NaturalNumber2();

        NaturalNumber y = new NaturalNumber2(x);
        NaturalNumber product2 = new NaturalNumber2();

        product = productOfDigits1(x);
        product2 = productOfDigits2(y);

        int number = toInt(y);

        out.println("method 1:" + product.toString() + "; n=" + x.toString());
        out.println("method 2:" + product2.toString() + "; n=" + y.toString());

        out.println("toInt:" + number);
        in.close();
        out.close();
    }

}
