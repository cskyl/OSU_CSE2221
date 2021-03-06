import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Simple HelloWorld program (clear of Checkstyle and FindBugs warnings).
 *
 * @author P. Bucci
 */
public final class HelloWorld {

    /**
     * Default constructor--private to prevent instantiation.
     */
    private HelloWorld() {
        // no code needed here
    }

    public static String reverseString(String s) {
        String rs = "";

        if (s.length() == 0) {
            rs = s;
        } else {
            char first = s.charAt(0);
            String subs = s.substring(1);
            String revSub = reverseString(subs);
            rs = revSub + first;
        }
        return rs;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        int b[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
        //a[5] = 100;
        SimpleWriter out = new SimpleWriter1L();
        SimpleWriter outout = out;
        out.println(a == b);
        out.close();
    }

}
