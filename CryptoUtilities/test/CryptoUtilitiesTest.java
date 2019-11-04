import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * @author Put your name here
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("0", n.toString());
        assertEquals("0", m.toString());
    }

    @Test
    public void testReduceToGCD_30_21() {
        SimpleWriter out = new SimpleWriter1L();

        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber m = new NaturalNumber2(21);
        CryptoUtilities.reduceToGCD(n, m);
        //out.println(n.toString());
        assertEquals("3", n.toString());
        assertEquals("0", m.toString());
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("0", n.toString());
        assertTrue(result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("1", n.toString());
        assertTrue(!result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        SimpleWriter out = new SimpleWriter1L();
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        out.println(n.toString());
        assertEquals("1", n.toString());
        assertEquals("0", p.toString());
        assertEquals("2", m.toString());
    }

    @Test
    public void testPowerMod_17_5_15() {
        SimpleWriter out = new SimpleWriter1L();
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber p = new NaturalNumber2(5);
        NaturalNumber m = new NaturalNumber2(15);

        //out.println("Running this");

        CryptoUtilities.powerMod(n, p, m);

        //out.println("Exit with n=" + n.toString());
        assertEquals("2", n.toString());
        assertEquals("5", p.toString());
        assertEquals("15", m.toString());
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("18", p.toString());
        assertEquals("19", m.toString());
    }

    @Test
    public void testPowerMod_10_11_12() {
        NaturalNumber n = new NaturalNumber2(10);
        NaturalNumber p = new NaturalNumber2(11);
        NaturalNumber m = new NaturalNumber2(12);
        CryptoUtilities.powerMod(n, p, m);
        SimpleWriter out = new SimpleWriter1L();
        //out.println("Exit with n=" + n.toString());
        //out.println("Exit with p=" + p.toString());

        assertEquals("4", n.toString());
        assertEquals("11", p.toString());
        assertEquals("12", m.toString());
    }

    @Test
    public void isWitness_3_8() {
        NaturalNumber w = new NaturalNumber2(3);
        NaturalNumber n = new NaturalNumber2(8);

        boolean isWitness = CryptoUtilities.isWitnessToCompositeness(w, n);

        assertEquals(true, isWitness);
    }

    @Test
    public void isWitness_4_7() {
        NaturalNumber w = new NaturalNumber2(4);
        NaturalNumber n = new NaturalNumber2(7);

        boolean isWitness = CryptoUtilities.isWitnessToCompositeness(w, n);

        assertEquals(false, isWitness);
    }

    @Test
    public void generatePrime() {
        NaturalNumber w = new NaturalNumber2(98);
        CryptoUtilities.generateNextLikelyPrime(w);
        SimpleWriter out = new SimpleWriter1L();
        out.println(w.toString());
        assertTrue(true);
    }

    @Test
    public void isPrime1_5() {
        NaturalNumber n = new NaturalNumber2(103);
        assertTrue(CryptoUtilities.isPrime2(n));
    }

}