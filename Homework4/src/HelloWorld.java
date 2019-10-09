import components.random.Random;
import components.random.Random1L;
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

    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        boolean inside;
        if ((xCoord - 1) * (xCoord - 1) + (yCoord - 1) * (yCoord - 1) <= 1) {
            inside = true;
        } else {
            inside = false;
        }
        return inside;
    }

    private static int numberOfPointsInCircle(int n) {
        int num = 0;
        double x, y;
        boolean in;
        Random rnd = new Random1L();
        for (int i = 0; i < n; i++) {
            x = 2 * rnd.nextDouble();
            y = 2 * rnd.nextDouble();
            in = pointIsInCircle(x, y);
            if (in == true) {
                num++;
                in = false;
            }

        }
        return num;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {
        int inside;
        SimpleWriter out = new SimpleWriter1L();

        inside = numberOfPointsInCircle(5);

        out.println(inside);
        out.close();
    }

}
