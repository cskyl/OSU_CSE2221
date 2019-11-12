import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyTest {

    @Test
    public void combinationTest1() {
        String str = StringReassembly.combination("abcde", "defgh", 2);
        SimpleWriter out = new SimpleWriter1L();
        out.println(str);
        out.close();
        assertEquals("abcdefgh", str);
    }

    @Test
    public void combinationTest2() {
        String str = StringReassembly.combination("123456", "1234567890", 6);
        assertEquals("1234567890", str);
    }

    @Test
    public void addToSetAvoidingSubstringsTest1() {
        String str1 = "Go bucks!";
        String str2 = "bucks!";
        String str3 = "Go bucks! Beat Michigan!";

        Set<String> ans = new Set1L<String>();
        Set<String> test = new Set1L<String>();

        ans.add(str3);
        ans.add("5");

        StringReassembly.addToSetAvoidingSubstrings(test, str1);
        StringReassembly.addToSetAvoidingSubstrings(test, str2);
        StringReassembly.addToSetAvoidingSubstrings(test, str3);
        StringReassembly.addToSetAvoidingSubstrings(test, "5");
        StringReassembly.addToSetAvoidingSubstrings(test, "b");

        SimpleWriter out = new SimpleWriter1L();
        out.println("ans: " + ans.toString());
        out.println("test:" + test.toString());

        out.close();
        assertEquals(ans, test);
    }

    @Test
    public void linesFromInputTest() {
        SimpleReader in = new SimpleReader1L("test.txt");
        SimpleWriter out = new SimpleWriter1L();
        Set<String> testSet = new Set1L<String>();
        Set<String> ansSet = new Set1L<String>();

        testSet = StringReassembly.linesFromInput(in);

        String str1 = "Bucks -- Beat";
        String str2 = "Go Bucks";
        String str3 = "o Bucks -- B";
        String str4 = "Beat Mich";
        String str5 = "ichigan~";
        String str6 = "Bucks";
        String str7 = "Michigan~";
        ansSet.add(str1);
        ansSet.add(str2);
        ansSet.add(str3);
        ansSet.add(str4);
        ansSet.add(str7);

        out.println(testSet.toString());
        out.println(ansSet.toString());

        out.close();

        assertEquals(ansSet, testSet);

    }

    @Test
    public void printWithLineSeparatorsTest() {
        String text = "abc~edf";
        SimpleWriter out = new SimpleWriter1L();
        StringReassembly.printWithLineSeparators(text, out);
    }

}
