import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

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

    private static int countValText(XMLTree t, String val) {
        int number = 0;
        if (!t.isTag()) {
            if (t.label().equals(val)) {
                number++;
            }
        } else {
            for (int i = 0; i < t.numberOfChildren(); i++) {
                number += countValText(t.child(i), val);
            }
        }
        return number;
    }

    private static int leafCount(XMLTree t) {
        int num = 0;
        if (t.numberOfChildren() > 0) {
            for (int i = 0; i < t.numberOfChildren(); i++) {
                num += leafCount(t.child(i));
            }
        }
        return num;
    }

    public static String makeMash(String s) {
        //String output = "";
        if (s.length() > 1) {
            char save = s.charAt(s.length() - 1);
            s = s.substring(0, s.length() - 1);
            s = makeMash(s);
            s += "*";
            s += save;
        }

        return s;

    }

    private static boolean evenSumOfDigits(NaturalNumber n) {
        boolean isEven = true;
        int number = 0;
        boolean lastEven = true;
        if (!n.isZero()) {
            number = n.divideBy10();
            lastEven = evenSumOfDigits(n);
            isEven = number % 2 == 0 ? true : false;
            n.multiplyBy10(number);
            if (!isEven) {
                if (!lastEven) {
                    isEven = true;
                }
            } else {
                if (isEven) {
                    if (!lastEven) {
                        isEven = false;
                    }
                }
            }
        }

        return isEven;
    }

    private static boolean digitAppears(NaturalNumber n, int digit) {
        boolean hasDigit = false;
        int num;
        if (!n.isZero()) {
            num = n.divideBy10();
            hasDigit = digitAppears(n, digit);
            if (!hasDigit) {
                hasDigit = (num == digit) ? true : false;
            }
        }

        return hasDigit;
    }

    private static String longestText(XMLTree t) {
        String str = "";
        String temp = "";
        if (t.isTag()) {
            for (int i = 0; i < t.numberOfChildren(); i++) {

                temp = longestText(t.child(i));
                if (temp.length() > str.length()) {
                    str = temp;
                }
            }
        } else {
            if (t.label().length() > str.length()) {
                str = t.label();
            }
        }

        return str;
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
        NaturalNumber oddTest = new NaturalNumber100(46);
        NaturalNumber sumTest = new NaturalNumber2(66);
        String test = "abcdef";
        String res = "";
        NaturalNumber hasDigitTest = new NaturalNumber2(101233);
        boolean hasDigit = digitAppears(hasDigitTest, 0);

        XMLTree t = new XMLTree1("test.xml");

        String str = longestText(t);
        out.println("Longest: " + str);

        out.println("hasDigit? " + hasDigit);

        res = makeMash(test);

        out.println(res);
        out.println(sumTest.toString() + " " + evenSumOfDigits(sumTest));
        out.println(oddTest.toString());
        out.print(((NaturalNumber100) oddTest).isOdd());

        in.close();
        out.close();
    }

}
