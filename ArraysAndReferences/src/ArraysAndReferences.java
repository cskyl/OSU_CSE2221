import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Program to test arrays, references, and arrays of references.
 *
 * @author Put your name here
 *
 */
public final class ArraysAndReferences {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ArraysAndReferences() {
    }

    /**
     * Computes the product of the {@code NaturalNumber}s in the given array.
     *
     * @param nnArray
     *            the array
     * @return the product of the numbers in the given array
     * @requires nnArray.length > 0
     * @ensures <pre>
     * productOfArrayElements =
     *    [nnArray[0] * nnArray[1] * ... * nnArray[nnArray.length-1]]
     * </pre>
     */
    private static NaturalNumber productOfArrayElements(
            NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";
        // TODO - fill in body
        NaturalNumber product = new NaturalNumber2(1);
        for (int i = 0; i < nnArray.length; i++) {
            product.multiply(nnArray[i]);
        }
        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
        return product;
    }

    /**
     * Replaces each element of {@code nnArray} with the partial product of all
     * the elements in the incoming array, up to and including the current
     * element.
     *
     * @param nnArray
     *            the array
     * @updates nnArray
     * @requires nnArray.length > 0
     * @ensures <pre>
     * for all i: integer where (0 <= i < nnArray.length)
     *   (nnArray[i] = [#nnArray[0] * #nnArray[1] * ... * #nnArray[i]])
     * </pre>
     */
    private static void computePartialProducts(NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";
        for (int i = 0; i < nnArray.length; i++) {
            if (i != 0) {
                nnArray[i].multiply(nnArray[i - 1]);
            }
        }
        // TODO - fill in body

    }

    /**
     * Creates and returns a new array of {@code NaturalNumber}s, of the same
     * size of the given array, containing the partial products of the elements
     * of the given array.
     *
     * @param nnArray
     *            the array
     * @return the array of partial products of the elements of the given array
     * @requires nnArray.length > 0
     * @ensures <pre>
     * partialProducts.length = nnArray.length  and
     *  for all i: integer where (0 <= i < partialProducts.length)
     *    (partialProducts[i] = [nnArray[0] * nnArray[1] * ... * nnArray[i]])
     * </pre>
     */
    private static NaturalNumber[] partialProducts(NaturalNumber[] nnArray) {
        assert nnArray != null : "Violation of: nnArray is not null";
        assert nnArray.length > 0 : "Violation of: nnArray.length > 0";

        // TODO - fill in body
        NaturalNumber[] partial = new NaturalNumber[nnArray.length];
        for (int k = 0; k < partial.length; k++) {

            partial[k] = new NaturalNumber2(1);
        }
        for (int i = 0; i < nnArray.length; i++) {
            for (int j = 0; j <= i; j++) {
                partial[i].multiply(nnArray[j]);
            }
        }
        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
        return partial;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();

        /*
         * Initialize an array of NaturalNumbers with values 1 through 42.
         */
        final int size = 42;
        NaturalNumber[] array = new NaturalNumber[size];
        NaturalNumber[] partial = new NaturalNumber[size];
        NaturalNumber count = new NaturalNumber2(1);
        for (int i = 0; i < array.length; i++) {
            array[i] = new NaturalNumber2(count);
            count.increment();
        }
        /*
         * Compute and output the product of the numbers in the array (should be
         * 42!, i.e., the factorial of 42).
         */
        NaturalNumber product = productOfArrayElements(array);
        partial = partialProducts(array);
        computePartialProducts(array);
        out.println("Product:" + product);
        for (int j = 0; j < partial.length; j++) {
            out.println("Partial Product Array:" + partial[j]);
        }
        for (int k = 0; k < array.length; k++) {
            out.println("Original Array:" + array[k]);
        }

        out.close();
    }

}