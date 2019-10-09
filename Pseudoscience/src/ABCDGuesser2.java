import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author Tony Han This program can help approximate a given positive value by
 *         giving four non-one positive values.
 *
 */
public final class ABCDGuesser2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser2() {
    }

    /**
     *  * Repeatedly asks the user for a positive real number until the user
     * enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *              the output stream  *
     * @return a positive real number entered by the user  
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        String rawInput;
        double posDouble;
        out.print("Enter a positive double: ");
        rawInput = in.nextLine();
        while (!FormatChecker.canParseDouble(rawInput)
                || Double.parseDouble(rawInput) <= 0) {
            out.print("Bad input, enter again: ");
            rawInput = in.nextLine();
        }
        posDouble = Double.parseDouble(rawInput);
        return posDouble;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        String rawInput;
        double posDoubleNotOne;
        out.print("Enter a positive double that is not 1: ");
        rawInput = in.nextLine();
        while (!FormatChecker.canParseDouble(rawInput)
                || Double.parseDouble(rawInput) - 1.0 <= 0.0001) {
            out.print("Bad input, enter again: ");
            rawInput = in.nextLine();
        }
        posDoubleNotOne = Double.parseDouble(rawInput);
        return posDoubleNotOne;
    }

    private static void showResult(final double[] EXPONENT, int[] exp,
            double[] userInput, double constant, double err, SimpleWriter out) {
        out.println("\nError: " + err);
        out.println(
                "Calculated Value: " + Math.pow(userInput[0], EXPONENT[exp[0]])
                        * Math.pow(userInput[1], EXPONENT[exp[1]])
                        * Math.pow(userInput[2], EXPONENT[exp[2]])
                        * Math.pow(userInput[3], EXPONENT[exp[3]]));
        for (int i = 0; i < 4; i++) {
            out.println(
                    "Exponent for " + userInput[i] + ": " + EXPONENT[exp[i]]);
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        final double EXPONENT[] = { -5.0, -4.0, -3.0, -2.0, -1.0, -1 / 2.0,
                -1 / 3.0, -1 / 4.0, 0.0, 1 / 2.0, 1 / 3.0, 1 / 4.0, 1.0, 2.0,
                3.0, 4.0, 5.0 };
        double constant;
        double approximateValue = 1;
        double userInput[] = { 0, 0, 0, 0 };
        int exp[] = { 0, 0, 0, 0 };
        double err;
        double lastErr = 1;
        int inputLoopControl = 0;
        int k = 0;
        long j = 0;
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        constant = getPositiveDouble(in, out);
        out.println("constant: " + constant);
        while (inputLoopControl < 4) {
            userInput[inputLoopControl] = getPositiveDoubleNotOne(in, out);
            inputLoopControl++;
        }

        for (int loop0Ctrl = 0; loop0Ctrl < 17; loop0Ctrl++) {
            for (int loop1Ctrl = 0; loop1Ctrl < 17; loop1Ctrl++) {
                for (int loop2Ctrl = 0; loop2Ctrl < 17; loop2Ctrl++) {
                    for (int loop3Ctrl = 0; loop3Ctrl < 17; loop3Ctrl++) {
                        approximateValue = Math.pow(userInput[0],
                                EXPONENT[loop0Ctrl])
                                * Math.pow(userInput[1], EXPONENT[loop1Ctrl])
                                * Math.pow(userInput[2], EXPONENT[loop2Ctrl])
                                * Math.pow(userInput[3], EXPONENT[loop3Ctrl]);

                        j++;
                        err = Math.abs(approximateValue - constant) / constant;
                        if (err < 0.01) {
                            if (err < lastErr) {
                                exp[0] = loop0Ctrl;
                                exp[1] = loop1Ctrl;
                                exp[2] = loop2Ctrl;
                                exp[3] = loop3Ctrl;
                                lastErr = err; //update smallest error
                                //out.println("err: " + err);  //for debugging
                            }

                            //out.println("Approximate: " + approximateValue);
                        }
                    }
                }
            }
        }

        showResult(EXPONENT, exp, userInput, constant, lastErr, out);
        in.close();
        out.close();
    }

}
