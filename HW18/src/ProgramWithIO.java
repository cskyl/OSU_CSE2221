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

class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if (s1.compareTo(s2) < 0) {
            return 1;
        } else if (s1.compareTo(s2) > 0) {
            return -1;
        } else {
            return 0;
        }
    }
}

public final class ProgramWithIO {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ProgramWithIO() {
    }

    /**
     * Removes and returns the minimum value from {@code q} according to the
     * ordering provided by the {@code compare} method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to compare entries
     * @return the minimum value from {@code q}
     * @updates q
     * @requires <pre>
     * q /= empty_string  and
     *  [the relation computed by order.compare is a total preorder]
     * </pre>
     * @ensures <pre>
     * perms(q * <removeMin>, #q)  and
     *  for all x: string of character
     *      where (x is in entries (q))
     *    ([relation computed by order.compare method](removeMin, x))
     * </pre>
     */
    private static String removeMin(Queue<String> q, Comparator<String> order) {

        String min = "";
        for (String item : q) {
            if (min.equals("")) {
                min = item;//init
            }
            int compare = order.compare(min, item);
            if (compare < 0) {//min < item
                min = item;
            }
        }

        Queue<String> temp = q.newInstance();
        temp.transferFrom(q);
        while (temp.length() != 0) {
            String tempStr = temp.dequeue();
            if (!tempStr.equals(min)) {
                q.enqueue(tempStr);
            }
        }
        return min;
    }

    /**
     * Sorts {@code q} according to the ordering provided by the {@code compare}
     * method from {@code order}.
     *
     * @param q
     *            the queue
     * @param order
     *            ordering by which to sort
     * @updates q
     * @requires [the relation computed by order.compare is a total preorder]
     * @ensures q = [#q ordered by the relation computed by order.compare]
     */
    public static void sort(Queue<String> q, Comparator<String> order) {

        if (q.length() != 0) {
            String str = removeMin(q, order);
            sort(q, order);
            q.enqueue(str);
        }
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

        Queue<String> q = new Queue1L<String>();
        StringComparator strCompare = new StringComparator();
        q.enqueue("fff");
        q.enqueue("aaa");
        q.enqueue("bbb");
        q.enqueue("ccc");
        q.enqueue("ddd");

        sort(q, strCompare);

        for (String item : q) {
            out.println(item);
        }

        out.println();
        in.close();
        out.close();
    }

}
