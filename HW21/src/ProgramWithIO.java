import components.set.Set;
import components.set.Set1L;
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

    /**
     * Generates the set of characters in the given {@code String} into the
     * given {@code Set}.
     *
     * @param str
     *            the given {@code String}
     * @param strSet
     *            the {@code Set} to be replaced
     * @replaces strSet
     * @ensures strSet = entries(str)
     */
    static void generateElements(String str, Set<Character> strSet) {
        Set<Character> temp = strSet.newInstance();
        temp.transferFrom(strSet);
        for (int i = 0; i < str.length(); i++) {
            if (!temp.contains(str.charAt(i))) {
                temp.add(str.charAt(i));
            }
        }
        strSet.transferFrom(temp);
    }

    /**
     * Returns the first "word" (maximal length string of characters not in
     * {@code separators}) or "separator string" (maximal length string of
     * characters in {@code separators}) in the given {@code text} starting at
     * the given {@code position}.
     *
     * @param text
     *            the {@code String} from which to get the word or separator
     *            string
     * @param position
     *            the starting index
     * @param separators
     *            the {@code Set} of separator characters
     * @return the first word or separator string found in {@code text} starting
     *         at index {@code position}
     * @requires 0 <= position < |text|
     * @ensures <pre>
     * nextWordOrSeparator =
     *   text[position, position + |nextWordOrSeparator|)  and
     * if entries(text[position, position + 1)) intersection separators = {}
     * then
     *   entries(nextWordOrSeparator) intersection separators = {}  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      intersection separators /= {})
     * else
     *   entries(nextWordOrSeparator) is subset of separators  and
     *   (position + |nextWordOrSeparator| = |text|  or
     *    entries(text[position, position + |nextWordOrSeparator| + 1))
     *      is not subset of separators)
     * </pre>
     */
    static String nextWordOrSeparator(String text, int position,
            Set<Character> separators) {
        boolean goingNext = true;
        String word = "";
        char firstChar = text.charAt(position);
        for (int i = position; goingNext && (i < text.length()); i++) {
            goingNext = false;
            if (separators.contains(firstChar)) {
                if (isSeparator(text.charAt(i), separators)) {
                    word += text.charAt(i);
                    goingNext = true;
                }
            } else {
                if (!isSeparator(text.charAt(i), separators)) {
                    word += text.charAt(i);
                    goingNext = true;
                }
            }
        }
        return word;
    }

    public static boolean isSeparator(Character c, Set<Character> sep) {
        boolean isSep = false;
        if (sep.contains(c)) {
            isSep = true;
        }
        return isSep;
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
         */
        Set<Character> sep = new Set1L<Character>();
        Set<Character> wordSet = new Set1L<Character>();
        sep.add(' ');
        sep.add('\n');
        sep.add('~');

        generateElements("Hello World", wordSet);

        in.close();
        out.close();
    }

}
