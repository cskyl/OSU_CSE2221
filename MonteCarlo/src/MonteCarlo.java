import components.random.Random;
import components.random.Random1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Monte Carlo Estimate: compute percentage of pseudo-random points in [0.0,1.0)
 * interval that fall in the left half subinterval [0.0,0.5).
 */
public final class MonteCarlo {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private MonteCarlo() {

    }

    /**
     * pointIsInCircle method: calculate if a point is in circle centered at
     * (1,1) with radius 1
     *
     * @param xCoord
     *            x-coordinate of the point
     *
     * @param yCoord
     *            y-coordinate of the point
     * @return inside If the point is inside the circle
     */
    private static boolean pointIsInCircle(double xCoord, double yCoord) {
        boolean inside;
        if ((xCoord - 1) * (xCoord - 1) + (yCoord - 1) * (yCoord - 1) <= 1) {
            inside = true;
        } else {
            inside = false;
        }
        return inside;
    }

    /**
     * numberOfPointsInCircle method: calculate how many points are in the
     * circle by given amount of total point
     *
     * @param n
     *            the number of point generated
     * @return num the number of point inside the circle
     */
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
        /*
         * Open input and output streams
         */
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();
        /*
         * Ask user for number of points to generate
         */
        output.print("Number of points: ");
        int n = input.nextInteger();
        /*
         * Declare counters and initialize them
         */
        int ptsInInterval = n, ptsInSubinterval = 0;
        ptsInSubinterval = numberOfPointsInCircle(ptsInInterval);
        /*
         * Estimate percentage of points generated in [0.0,1.0) interval that
         * fall in the [0.0,0.5) subinterval
         */
        double estimate = (100.0 * ptsInSubinterval) / ptsInInterval;
        output.println("Estimate of percentage: " + estimate + "%");
        output.println("The estimate area is " + estimate * 4 / 100);
        /*
         * Close input and output streams
         */
        input.close();
        output.close();
    }

}