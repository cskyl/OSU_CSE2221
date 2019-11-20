import java.util.Comparator;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program can generate a set of html files that each includes a term with
 * definition and an index by given txt file containing terms and definitions
 *
 * @author Tony Han
 *
 */
public final class Glossary {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Glossary() {
    }

    /**
     * Read lines from given file and convert them into a maps that saves
     * {@code key} as key, {@code value} as value.
     *
     * @param in
     *            the input file reader
     * @param Dictionary
     *            the output map that saves term and definition pairs
     * @update Dictionary
     */
    public static void inputData(SimpleReader in,
            Map<String, String> Dictionary) {
        String key = "";
        String value = "";

        while (!in.atEOS()) {
            String temp = in.nextLine();
            if (isSingleWord(temp)) {
                key = temp;
            } else if (isSentence(temp)) {
                value += temp;
            } else {
                Dictionary.add(key, value);
                key = "";
                value = "";
            }
        }
        if (key.length() > 0 && value.length() > 0) {
            Dictionary.add(key, value);
        }
    }

    /**
     * Verify if {@code str} is a single word.
     *
     * @param str
     *            given string
     * @return if {@code str} is a single
     *
     */
    public static boolean isSingleWord(String str) {
        boolean isWord = true;
        if (str.length() < 1) {
            isWord = false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    isWord = false;
                }
            }
        }
        return isWord;
    }

    /**
     * Verify if {@code str} is a sentence.
     *
     * @param str
     *            the input String
     * @return if {@code str is a sentence}
     */
    public static boolean isSentence(String str) {
        boolean isSentence = false;
        if (str.length() < 1) {
            isSentence = false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    isSentence = true;
                }
            }
        }
        return isSentence;
    }

    private static class AtoZ implements Comparator<String> {

        /**
         * compares which String is bigger.
         *
         * @param str1
         *            the first String
         * @param str2
         *            the second String
         * @return 1 if {@code str1} is larger than {@code str2} -1 if
         *         {@code str1} is larger than {@code str2} 0 if @code str1}
         *         equals to {@code str2}
         */
        @Override
        public int compare(String str1, String str2) {
            if (str1.compareTo(str2) > 0) {
                return 1;
            } else if (str1.compareTo(str2) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * prints index.html
     *
     * @param entries
     *            all terms that need to be printed with hyperlink
     * @param filePath
     *            where to generate file
     */
    public static void printIndex(Queue<String> entries, String filePath) {
        SimpleWriter index = new SimpleWriter1L(filePath + "/" + "index.html");
        index.print(
                "<html>\n<head>\n<title>Cy Burnett's Glossary Index</title>\n</head>\n");
        index.print(
                "<body>\n<h2>Cy Burnett's Glossary Index</h2>\n<hr />\n<h3>Index</h3>\n<ul>\n");
        for (String term : entries) {
            index.println(
                    "<li><a href=\"" + term + ".html\">" + term + "</a></li>");
        }
        index.print("</ul>\n</body>\n</html>\n");
        index.close();
    }

    /**
     * Extracts terms from the Map and converts them into a sorted Queue.
     *
     * @param Dictionary
     *            the given Map that stores all terms with definition
     * @return A sorted Queue<String> that stores all terms
     */
    public static Queue<String> MapToSortedQueue(
            Map<String, String> Dictionary) {
        Queue<String> entries = new Queue1L<String>();
        for (Map.Pair<String, String> terms : Dictionary) {
            entries.enqueue(terms.key());
        }

        Comparator<String> strCompare = new AtoZ();
        entries.sort(strCompare);
        return entries;
    }

    /**
     * Prints all terms, each with "terms".index.
     *
     * @param Dictionary
     *            a Map<String, String> that stores all terms with definitions
     * @param filePath
     *            where to generate files
     */
    public static void printTerms(Map<String, String> Dictionary,
            String filePath) {
        Set<String> terms = new Set1L<String>();
        for (Map.Pair<String, String> term : Dictionary) {
            SimpleWriter out = new SimpleWriter1L(
                    filePath + "/" + term.key() + ".html");
            out.print("<html>\n<head>\n<title>" + term.key()
                    + "</title>\n</head>\n");
            out.print("<body>\n<h2><b><i><font color=\"red\">" + term.key()
                    + "</font></i></b></h2>\n");
            String definition = term.value();
            terms = FindTermsInSentence(term.value(), Dictionary);
            for (String words : terms) {
                definition = definition.substring(0, definition.indexOf(words))
                        + generateHyperlink(words) + words + "</a>"
                        + definition.substring(
                                definition.indexOf(words) + words.length());
            }
            //SimpleWriter toCMD = new SimpleWriter1L();
            //toCMD.println(definition);
            out.print("<blockquote>" + definition + "</blockquote>");
            out.println("<hr />");
            out.println("<p>Return to <a href=\"index.html\">index</a>.</p>");
            out.print("</body>\n</html>");
        }
    }

    /**
     * Finds all terms in a definition sentence
     *
     * @param str
     *            the given definition
     * @param Dictionary
     *            a Map<String, String> that stores all terms
     * @return a Set<String> that stores all terms exist in the given definition
     */
    public static Set<String> FindTermsInSentence(String str,
            Map<String, String> Dictionary) {
        Set<String> terms = new Set1L<String>();
        for (Map.Pair<String, String> term : Dictionary) {
            if (str.contains(term.key()) && !terms.contains(term.key())) {
                terms.add(term.key());
            }
        }
        return terms;
    }

    /**
     * prints hyperlink for terms in definitions
     *
     * @param word
     *            given terms
     * @return a String with generated html code
     */
    public static String generateHyperlink(String word) {
        return "<a href=\"" + word + ".html\">";
    }

    /**
     * program diver
     *
     * @param args
     *            won't be used in program
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        Map<String, String> dictionary = new Map1L<String, String>();

        out.print("Please enter your txt file:");
        String fileName = in.nextLine();
        out.print("Please enter your folder:");
        String filePath = in.nextLine();
        SimpleReader fileReader = new SimpleReader1L(fileName);
        inputData(fileReader, dictionary);

        out.println(dictionary.toString());

        Queue<String> entries = new Queue1L<String>();
        entries = MapToSortedQueue(dictionary);
        printIndex(entries, filePath);
        printTerms(dictionary, filePath);

        in.close();
        out.close();
    }

}
