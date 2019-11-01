import java.util.Comparator;

import components.queue.Queue;
import components.queue.Queue1L;
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
public final class ProgramWithIO {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramWithIO() {
    }

    private static class LtoH implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2) {
                return -1;
            } else if (o1 > o2) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    private static class HtoL implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2) {
                return 1;
            } else if (o1 > o2) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Reports the smallest integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return the smallest integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * min is in entries(q) and
     *  for all x: integer
     *      where (x is in entries(q))
     *    (min <= x)
     * </pre>
     */
    private static int min(Queue<Integer> q) {
        Comparator<Integer> ci = new LtoH();
        q.sort(ci);
        int min = q.front();
        return min;
    }

    /**
     * Reports an array of two {@code int}s with the smallest and the largest
     * integer in the given {@code Queue<Integer>}.
     *
     * @param q
     *            the queue of integer
     * @return an array of two {@code int}s with the smallest and the largest
     *         integer in the given queue
     * @requires q /= empty_string
     * @ensures <pre>
     * { minAndMax[0], minAndMax[1] } is subset of entries(q) and
     *  for all x: integer
     *      where (x in in entries(q))
     *    (minAndMax[0] <= x <= minAndMax[1])
     * </pre>
     */
    private static int[] minAndMax(Queue<Integer> q) {
        int[] minMax = new int[2];
        Comparator<Integer> ci = new LtoH();
        q.sort(ci);

        minMax[0] = q.front();
        q.flip();
        minMax[1] = q.front();
        q.flip();

        return minMax;

    }

    private static int[] minAndMax2(Queue<Integer> q) {

        Queue<Integer> large = new Queue1L<Integer>();
        Queue<Integer> small = new Queue1L<Integer>();

        Comparator<Integer> ci = new LtoH();
        int[] minAndMax = new int[2];
        while (q.length() > 0) {
            if (q.length() % 2 == 0) {
                int a = q.dequeue();
                int b = q.dequeue();
                if (a >= b) {
                    large.enqueue(a);
                    small.enqueue(b);
                } else {
                    large.enqueue(b);
                    small.enqueue(a);
                }

            } else {
                int a = q.dequeue();

                large.enqueue(a);
                small.enqueue(a);
            }
        }

        large.sort(ci);
        large.flip();
        small.sort(ci);

        minAndMax[0] = small.front();
        minAndMax[1] = large.front();

        return minAndMax;
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

        Queue<Integer> test = new Queue1L<Integer>();
        test.enqueue(5);
        test.enqueue(1);
        test.enqueue(88);

        int[] two = new int[2];
        two = minAndMax2(test);

        out.println(two[0] + " " + two[1]);
        /*
         * Put your main program code here
         */
        /*
         * Close input and output streams
         */

        in.close();
        out.close();
    }

}
