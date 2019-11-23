/**
 * Model interface.
 *
 * The DemoGUI model consists of the input and output strings.
 *
 * @author Bruce W. Weide
 * @author Paolo Bucci
 *
 * @mathmodel <pre>
 * type DemoModel is modeled by
 *   (input: string of character,
 *    output: string of character)
 * </pre>
 * @initially <pre>
 * ():
 *   ensures
 *     this = ("", "")
 * </pre>
 */
public interface DemoModel {

    /**
     * Reports this.input.
     *
     * @return this.input
     * @ensures input = this.input
     */
    String input();

    /**
     * Sets this.input to argument.
     *
     * @param input
     *            new this.input value
     * @replaces this.input
     * @ensures this.input = input
     */
    void setInput(String input);

    /**
     * Reports this.output.
     *
     * @return this.output
     * @ensures output = this.output
     */
    String output();

    /**
     * Sets this.output to argument.
     *
     * @param output
     *            new this.output value
     * @replaces this.output
     * @ensures this.output = output
     */
    void setOutput(String output);

}
