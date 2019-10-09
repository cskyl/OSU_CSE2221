import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class IntegerDivision {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private IntegerDivision() {
        // no code needed here
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        final long microsPerDay = Long.parseUnsignedLong("86400000000");
        final long millisPerDay = 24 * 60 * 60 * 1000;

        out.println(microsPerDay);

        out.println(millisPerDay);

        out.println(microsPerDay / millisPerDay);
        out.close();
    }

}
