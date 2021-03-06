import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class HW10 {

    /**
     * Swaps the two given {@code NaturalNumber}s.
     *
     * @param n1
     *            the first {@code NaturalNumber}
     * @param n2
     *            the second {@code NaturalNumber}
     * @updates n1
     * @updates n2
     * @ensures n1 = #n2 and n2 = #n1
     */
    private static void swapNN(NaturalNumber n1, NaturalNumber n2) {
        NaturalNumber temp = new NaturalNumber2(n1);
        n1.copyFrom(n2);
        n2.copyFrom(temp);
    }

    /**
     * Swaps the two given {@code NaturalNumber}s.
     *
     * @param n1
     *            the first {@code NaturalNumber}
     * @param n2
     *            the second {@code NaturalNumber}
     * @requires n1 and n2 must of same implementation
     * @updates n1
     * @updates n2
     * @ensures n1 = #n2 and n2 = #n1
     */
    private static void swapNN2(NaturalNumber n1, NaturalNumber n2) {
        NaturalNumber temp = new NaturalNumber2(n1);
        n1.transferFrom(n2);
        n2.transferFrom(temp);
    }

    /**
     * Squares a given {@code NaturalNumber}.
     *
     * @param n
     *            the number to square
     * @updates n
     * @ensures n = #n * #n
     */
    private static void square(NaturalNumber n) {
        NaturalNumber temp = new NaturalNumber2();
        temp.copyFrom(n);
        n.multiply(temp);
    }

    public static void main(String args[]) {

        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.println("N1=");
        NaturalNumber n1 = new NaturalNumber2(in.nextLine());
        out.println("N2=");
        NaturalNumber n2 = new NaturalNumber2(in.nextLine());
        out.println("N3=");
        NaturalNumber n3 = new NaturalNumber2(in.nextLine());

        swapNN2(n1, n2);

        square(n3);

        out.println("\nN1=" + n1.toString());
        out.println("N2=" + n2.toString());
        out.println("N3=" + n3.toString());

        in.close();
        out.close();
    }

}
