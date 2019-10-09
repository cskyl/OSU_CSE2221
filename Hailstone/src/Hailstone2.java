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
public final class Hailstone2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Hailstone2() {
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
        int len = 1;
        while (num != 1) {
            len++;
            if (num % 2 == 0 || num == 2) {
                num /= 2;
            }
            if (num % 2 == 1 && num != 1) {
                num *= 3;
                num++;
            }
        }
        out.print("\nThe length of the series: " + len);
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

        out.print("Enter the first number: ");
        input = in.nextInteger();

        generateSeries(input, out);

        in.close();
        out.close();
    }

}
