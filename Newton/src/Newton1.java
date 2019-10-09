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
public final class Newton1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton1() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        double r;
        double check;
        r = x;
        r = ((r + x / r) / 2);
        check = (r * r - x) / x;
        while ((check > 0.0001 * 0.0001 && check > 0)
                || (check < -0.0001 * 0.0001 && check < 0)) {
            r = ((r + x / r) / 2);//A process of newton iteration to estimate
            check = (r * r - x) / x;
        }
        return r;
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
         * Put your main program code here; it may call myMethod as shown
         */
        String str;
        double input_num;
        double sqrt_num;
        out.print("Do you wish to calculate the square root (y to continue): ");
        str = in.nextLine();
        while (str.equals("y")) {
            out.print("Enter a double number: ");
            input_num = in.nextDouble();

            sqrt_num = sqrt(input_num);//calculate estimate square root of input_num
            out.println(
                    "Enter square root of " + input_num + " is " + sqrt_num);
            out.print(
                    "Do you wish to calculate another square root? (y to continue): ");
            str = in.nextLine();
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
