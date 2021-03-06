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
public final class XMLTreeIntExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeIntExpressionEvaluator() {
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
    private static int evaluate(XMLTree exp) {
        assert exp != null : "Violation of: exp is not null";

        int result = 0;
        // TODO - fill in body
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
        /*
         * This line added just to make the program compilable. Should be
         * replaced with appropriate return statement.
         */
        return result;
    }

    /**
     * Calculate the value of the given expression
     *
     * @param a
     *            the first number (can be either a String or an int)
     *
     * @param b
     *            the second number (can be either a String or an int)
     *
     * @param symbol
     *            the symbol of the expression
     * @return the value of the expression
     * @ensures calc = [the value of the expression]
     */

    private static int calc(int a, String b, String symbol) {
        assert !(symbol.equals("divide")
                && b.equals("0")) : "Violation of: Denominator can not be zero";

        int result = 0;
        int valB = Integer.parseInt(b);

        if (symbol.equals("plus")) {
            result = a + valB;
        }
        if (symbol.equals("minus")) {
            result = a - valB;
        }
        if (symbol.equals("times")) {
            result = a * valB;
        }
        if (symbol.equals("divide")) {
            result = a / valB;
        }

        return result;
    }

    /**
     * Calculate the value of the given expression
     *
     * @param a
     *            the first number (can be either a String or an int)
     *
     * @param b
     *            the second number (can be either a String or an int)
     *
     * @param symbol
     *            the symbol of the expression
     * @return the value of the expression
     * @ensures calc = [the value of the expression]
     */
    private static int calc(String a, int b, String symbol) {
        assert !(symbol.equals("divide")
                && b != 0) : "Violation of: Denominator can not be zero";

        int result = 0;
        int valA = Integer.parseInt(a);

        if (symbol.equals("plus")) {
            result = valA + b;
        }
        if (symbol.equals("minus")) {
            result = valA - b;
        }
        if (symbol.equals("times")) {
            result = valA * b;
        }
        if (symbol.equals("divide")) {
            result = valA / b;
        }

        return result;
    }

    /**
     * Calculate the value of the given expression
     *
     * @param a
     *            the first number (can be either a String or an int)
     *
     * @param b
     *            the second number (can be either a String or an int)
     *
     * @param symbol
     *            the symbol of the expression
     * @return the value of the expression
     * @ensures calc = [the value of the expression]
     */
    private static int calc(String a, String b, String symbol) {
        assert !(symbol.equals("divide")
                && b.equals("0")) : "Violation of: Denominator can not be zero";

        int result = 0;
        int valA = Integer.parseInt(a);
        int valB = Integer.parseInt(b);
        if (symbol.equals("plus")) {
            result = valA + valB;
        }
        if (symbol.equals("minus")) {
            result = valA - valB;
        }
        if (symbol.equals("times")) {
            result = valA * valB;
        }
        if (symbol.equals("divide")) {
            result = valA / valB;
        }

        return result;
    }

    /**
     * Calculate the value of the given expression
     *
     * @param a
     *            the first number (can be either a String or an int)
     *
     * @param b
     *            the second number (can be either a String or an int)
     *
     * @param symbol
     *            the symbol of the expression
     * @return the value of the expression
     * @ensures calc = [the value of the expression]
     */
    private static int calc(int a, int b, String symbol) {
        assert !(symbol.equals("divide")
                && b == 0) : "Violation of: Denominator can not be zero";

        int result = 0;

        if (symbol.equals("plus")) {
            result = a + b;
        }
        if (symbol.equals("minus")) {
            result = a - b;
        }
        if (symbol.equals("times")) {
            result = a * b;
        }
        if (symbol.equals("divide")) {
            result = a / b;
        }

        return result;
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