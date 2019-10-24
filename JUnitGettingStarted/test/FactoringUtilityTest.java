import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Sample JUnit test fixture for FactoringUtility.
 *
 * @author Paolo Bucci
 *
 */
public final class FactoringUtilityTest {

    /**
     * Test aFactor with input 0.
     */
    @Test
    public void aFactorTest1() {
        /*
         * Set up variables and call method under test
         */
        int n = 555;
        int factor = FactoringUtility.aFactor(n);
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(factor > 0);
        assertEquals(0, n % factor);

    }

    /**
     * Test aFactor with input 1.
     */
    @Test
    public void aFactorTest2() {
        /*
         * Set up variables and call method under test
         */
        int n = 1;
        int factor = FactoringUtility.aFactor(n);
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(factor > 0);
        assertEquals(0, n % factor);
    }

    /**
     * Test aFactor with input 2.
     */
    @Test
    public void aFactorTest3() {
        /*
         * Set up variables and call method under test
         */
        int n = 2;
        int factor = FactoringUtility.aFactor(n);
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(factor > 0);
        assertEquals(0, n % factor);
    }

    /**
     * Test aFactor with input 4.
     */
    @Test
    public void aFactorTest4() {
        /*
         * Set up variables and call method under test
         */
        int n = 4;
        int factor = FactoringUtility.aFactor(n);
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(factor > 0);
        assertEquals(0, n % factor);
    }

    /**
     * Test aFactor with input 12.
     */
    @Test
    public void aFactorTest5() {
        /*
         * Set up variables and call method under test
         */
        int n = 12;
        int factor = FactoringUtility.aFactor(n);
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(factor > 0);
        assertEquals(0, n % factor);
    }

    /**
     * Test aNonTrivialFactorV1 with input 15.
     */
    @Test
    public void aNonTrivialFactorV1Test1() {
        /*
         * Set up variables and call method under test
         */
        int n = 15;
        int factor = FactoringUtility.aNonTrivialFactorV1(n);
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(1 < factor);
        assertTrue(factor < n);
        assertEquals(0, n % factor);
    }

    /**
     * Test aNonTrivialFactorV1 with input 17.
     */
    @Test
    public void aNonTrivialFactorV1Test2() {
        /*
         * Set up variables and call method under test
         */
        int n = 21;
        int factor = FactoringUtility.aNonTrivialFactorV1(n);
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(1 < factor);
        assertTrue(factor < n);
        assertEquals(0, n % factor);
    }

    /**
     * Test aNonTrivialFactorV1 with input 32.
     */
    @Test
    public void aNonTrivialFactorV1Test3() {
        /*
         * Set up variables and call method under test
         */
        int n = 32;
        int factor = FactoringUtility.aNonTrivialFactorV1(n);
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(1 < factor);
        assertTrue(factor < n);
        assertEquals(0, n % factor);
    }

    /**
     * Test aNonTrivialFactorV2 with input 12.
     */
    @Test
    public void aNonTrivialFactorV2Test1() {
        /*
         * Set up variables and call method under test
         */
        int n = 12;
        int factor = FactoringUtility.aNonTrivialFactorV2(n);
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(1 < factor);
        assertTrue(factor < n);
        assertEquals(0, n % factor);
    }

    /**
     * Test aNonTrivialFactorV2 with input 15.
     */
    @Test
    public void aNonTrivialFactorV2Test2() {
        /*
         * Set up variables and call method under test
         */
        int n = 15;
        int factor = FactoringUtility.aNonTrivialFactorV2(n);
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(1 < factor);
        assertTrue(factor < n);
        assertEquals(0, n % factor);
    }

    /**
     * Test aNonTrivialFactorV2 with input 25.
     */
    @Test
    public void aNonTrivialFactorV2Test3() {
        /*
         * Set up variables and call method under test
         */
        int n = 25;
        int factor = FactoringUtility.aNonTrivialFactorV2(n);
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(1 < factor);
        assertTrue(factor < n);
        assertEquals(0, n % factor);
    }

    /**
     * Test aNonTrivialFactorV3 with input 16.
     */
    @Test
    public void aNonTrivialFactorV3Test1() {
        /*
         * Set up variables and call method under test
         */
        int n = 16;
        int factor = FactoringUtility.aNonTrivialFactorV3(n);
        /*
         * Assert that values of variables match expectations
         */
        assertTrue(1 < factor);
        assertTrue(factor < n);
        assertEquals(0, n % factor);
    }

}