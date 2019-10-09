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
public final class Hailstone4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone4() {
    }

    /**
     * Generates and outputs the Hailstone series starting with the given
     * integer.
     *
     * @param n
     *            the starting integer
     * @param out
     *            the output stream
     */
    private static void generateSeries(int n, SimpleWriter out) {
        out.print(n + " ");
        int num = n;
        int max = num;
        while (num != 1) {
            if (num % 2 == 0 || num == 2) {
                num /= 2;
            }
            if (num % 2 == 1 && num != 1) {
                num *= 3;
                num++;
            }
            if (max < num) {
                max = num;
            }
        }
        out.println("\nThe max is: " + max);
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
        int input;
        int len = 0;
        int max;
        max = len;
        out.print("Enter the first number: ");
        input = in.nextInteger();
        //generateSeries(i, out);

        in.close();
        out.close();
    }

}
