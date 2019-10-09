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
public final class CoinChange2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private CoinChange2() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        int cent;
        int money_value[] = { 100, 50, 25, 10, 5, 1 };
        int number_coin[] = { 0, 0, 0, 0, 0, 0 };

        SimpleWriter out = new SimpleWriter1L();
        SimpleReader in = new SimpleReader1L();
        out.println("Enter how many cents do you want to change: ");
        cent = in.nextInteger();
        for (int i = 0; i < 6; i++) {
            number_coin[i] = cent / money_value[i];
            cent = cent % money_value[i];
        }
        for (int i = 0; i < 6; i++) {
            out.print(money_value[i] + " cent(s) coin: ");
            out.println(number_coin[i]);
        }
        out.close();
    }

}
