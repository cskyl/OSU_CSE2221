import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
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

        Set<String> ans = new Set1L();
        Set<String> test = new Set1L();

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

}
