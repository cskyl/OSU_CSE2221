import components.sequence.Sequence;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.stack.Stack;

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
         * Put your main program code here
         */
        /*
         * Close input and output streams
         *
         */

        Stack<String> testStack = new Stack99<String>();
        Sequence<String> testSequence = new Sequence100<String>();

        testStack.push("FIRST");
        testStack.push("SECOND");
        testStack.push("THIRD");
        testStack.push("FORTH");

        testSequence.add(0, "FORTH");
        testSequence.add(0, "THIRD");
        testSequence.add(0, "SECOND");
        testSequence.add(0, "FIRST");

        testStack.flip();
        testSequence.flip();

        out.println(testStack.toString());
        out.println(testSequence.toString());
        in.close();
        out.close();
    }

}
