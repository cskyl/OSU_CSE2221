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
public final class TestingToStringWithCommas {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private TestingToStringWithCommas() {
    }

    
    /**
     * Converts the given {@code NaturalNumber} to a {@code String} with commas.
     *
     * @param n
     *            the number
     * @return the {@code String} with commas
     * @ensures toStringWithCommas = [String representation of n with commas]
     */
    public static String toStringWithCommas(NaturalNumber n) {
        int digit = 0;
        String str = "";
        if (!n.isZero()) {
            for (int i = 0; !n.isZero() && i < 3; i++) {
                digit = n.divideBy10();
                str += Integer.toString(digit);
            }
            if (n.compareTo(new NaturalNumber2(10)) > 10) {
                str += ",";
            }

            str += toStringWithCommas(n);
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
        in.close();
        out.close();
    }

}
