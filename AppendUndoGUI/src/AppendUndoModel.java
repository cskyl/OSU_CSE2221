import components.stack.Stack;

/**
 * Model interface.
 *
 * The AppendUndo model consists of the input string and a stack of the strings
 * appended to the output in reverse order.
 *
 * @author Bruce W. Weide
 * @author Paolo Bucci
 *
 * @mathmodel <pre>
 * {@code type AppendUndoModel is modeled by
 *   (input: string of character,
 *    output: string of string of character)}
 * </pre>
 * @initially <pre>
 * {@code default:
 *   ensures
 *     this = ("", <>)}
 * </pre>
 */
public interface AppendUndoModel {

    /**
     * Reports this.input.
     *
     * @return this.input
     * @ensures <pre>
     * {@code input = this.input}
     * </pre>
     */
    String input();

    /**
     * Sets this.input to argument.
     *
     * @param input
     *            new this.input value
     * @ensures <pre>
     * {@code this.input = input}
     * </pre>
     */
    void setInput(String input);

    /**
     * Reports this.output.
     *
     * @return this.output
     * @aliases reference returned by {@code output}
     * @ensures <pre>
     * {@code output = this.output}
     * </pre>
     */
    Stack<String> output();

}
