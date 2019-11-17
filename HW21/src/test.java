import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class test {

    @Test
    public void generateElementsTest1() {
        Set<Character> ans = new Set1L<Character>();
        Set<Character> wordSet = new Set1L<Character>();

        ans.add('H');
        ans.add('e');
        ans.add('l');
        ans.add('o');
        ans.add(' ');
        ans.add('!');
        ans.add('\n');

        ProgramWithIO.generateElements("Hello !\n", wordSet);

        SimpleWriter out = new SimpleWriter1L();
        //out.println(ans.toString());
        //out.println(wordSet.toString());
        out.close();
    }

    @Test
    public void nextWordOrSeparatorTest1() {
        Set<Character> sep = new Set1L<Character>();
        sep.add('\n');
        sep.add(' ');
        sep.add('!');
        sep.add('-');
        String word = ProgramWithIO.nextWordOrSeparator("Hello Wor~ld! -", 0,
                sep);
        String word2 = ProgramWithIO.nextWordOrSeparator("Hello Wor~ld! -", 6,
                sep);
        String word3 = ProgramWithIO.nextWordOrSeparator("Hello Wor~ld! -ABCD",
                12, sep);
        SimpleWriter out = new SimpleWriter1L();
        out.println(word);
        assertEquals(word, "Hello");
        assertEquals(word2, "Wor~ld");
        assertEquals(word3, "! -");
    }

}
