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
 * Put a short phrase describing the program here.
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

    public static String generateHyperlink(String word) {
        return "<a href=\"" + word + ".html\">";
    }

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
