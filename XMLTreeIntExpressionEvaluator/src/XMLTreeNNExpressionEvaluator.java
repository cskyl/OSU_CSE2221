import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Tony Han
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * </pre>
     * @ensures evaluate = [the value of the expression]
     */

    private static NaturalNumber evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        NaturalNumber result = new NaturalNumber2();
        if (exp.isTag()) {
            if (exp.child(0).label().equals("number")) {
                if (exp.child(1).label().equals("number")) {
                    result = calc(exp.child(0).attributeValue("value"),
                            exp.child(1).attributeValue("value"), exp.label());
                } else {
                    result = calc(exp.child(0).attributeValue("value"),
                            evaluate(exp.child(1)), exp.label());
                }
            } else {
                if (exp.child(1).label().equals("number")) {
                    result = calc(evaluate(exp.child(0)),
                            exp.child(1).attributeValue("value"), exp.label());
                } else {
                    result = calc(evaluate(exp.child(0)),
                            evaluate(exp.child(1)), exp.label());
                }
            }
        }
        return result;
    }

    /**
     * Calculate the value of the given expression
     *
     * @param a
     *            the first number (can be either a String or a NaturalNumber)
     *
     * @param b
     *            the second number (can be either a String or a NaturalNumber)
     *
     * @param symbol
     *            the symbol of the expression
     * @return the value of the expression
     * @requires
     * @ensures calc = [the value of the expression]
     */
    private static NaturalNumber calc(String a, NaturalNumber b,
            String symbol) {
        assert !(symbol.equals("divide")
                && b.isZero()) : "Violation of: Denominator can not be zero";

        NaturalNumber valA = new NaturalNumber2(a);
        if (symbol.equals("plus")) {
            valA.add(b);
        }
        if (symbol.equals("minus")) {
            valA.subtract(b);
        }
        if (symbol.equals("times")) {
            valA.multiply(b);
        }
        if (symbol.equals("divide")) {
            valA.divide(b);
        }

        return valA;
    }

    /**
     * Calculate the value of the given expression
     *
     * @param a
     *            the first number (can be either a String or a NaturalNumber)
     *
     * @param b
     *            the second number (can be either a String or a NaturalNumber)
     *
     * @param symbol
     *            the symbol of the expression
     * @return the value of the expression
     * @ensures calc = [the value of the expression]
     */
    private static NaturalNumber calc(NaturalNumber a, String b,
            String symbol) {
        assert !(symbol.equals("divide")
                && b.equals("0")) : "Violation of: Denominator can not be zero";

        NaturalNumber result = new NaturalNumber2(a);
        NaturalNumber valB = new NaturalNumber2(b);
        if (symbol.equals("plus")) {
            result.add(valB);
        }
        if (symbol.equals("minus")) {
            result.subtract(valB);
        }
        if (symbol.equals("times")) {
            result.multiply(valB);
        }
        if (symbol.equals("divide")) {
            result.divide(valB);
        }

        return result;
    }

    /**
     * Calculate the value of the given expression
     *
     * @param a
     *            the first number (can be either a String or a NaturalNumber)
     *
     * @param b
     *            the second number (can be either a String or a NaturalNumber)
     *
     * @param symbol
     *            the symbol of the expression
     * @return the value of the expression
     * @ensures calc = [the value of the expression]
     */
    private static NaturalNumber calc(String a, String b, String symbol) {
        assert !(symbol.equals("divide")
                && b.equals("0")) : "Violation of: Denominator can not be zero";

        NaturalNumber valA = new NaturalNumber2(a);
        NaturalNumber valB = new NaturalNumber2(b);
        if (symbol.equals("plus")) {
            valA.add(valB);
        }
        if (symbol.equals("minus")) {
            valA.subtract(valB);
        }
        if (symbol.equals("times")) {
            valA.multiply(valB);
        }
        if (symbol.equals("divide")) {
            valA.divide(valB);
        }

        return valA;
    }

    /**
     * Calculate the value of the given expression
     *
     * @param a
     *            the first number (can be either a String or a NaturalNumber)
     *
     * @param b
     *            the second number (can be either a String or a NaturalNumber)
     *
     * @param symbol
     *            the symbol of the expression
     * @return the value of the expression
     * @ensures calc = [the value of the expression]
     */
    private static NaturalNumber calc(NaturalNumber a, NaturalNumber b,
            String symbol) {
        assert !(symbol.equals("divide")
                && b.isZero()) : "Violation of: Denominator can not be zero";
        NaturalNumber valA = new NaturalNumber2(a);
        if (symbol.equals("plus")) {
            valA.add(b);
        }
        if (symbol.equals("minus")) {
            valA.subtract(b);
        }
        if (symbol.equals("times")) {
            valA.multiply(b);
        }
        if (symbol.equals("divide")) {
            valA.divide(b);
        }

        return valA;
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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            exp.child(0).display();
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}
