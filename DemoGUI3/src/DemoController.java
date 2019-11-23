/**
 * Controller interface.
 *
 * @author Bruce W. Weide
 * @author Paolo Bucci
 *
 * @mathmodel <pre>
 * type DemoController is modeled by
 *   (model: DemoModel,
 *    view: DemoView)
 * </pre>
 * @initially <pre>
 * (DemoModel model, DemoView view):
 *   ensures
 *     this.model = model  and
 *     this.view = view
 * </pre>
 */
public interface DemoController {

    /**
     * Processes event to reset model.
     *
     * @updates this.model, this.view
     * @ensures <pre>
     * this.model.input = ""  and
     * this.model.output = ""  and
     * [this.view has been updated to match this.model]
     * </pre>
     */
    void processResetEvent();

    /**
     * Processes event to copy input to output.
     *
     * @param input
     *            string to be copied
     *
     * @updates this.model, this.view
     * @ensures <pre>
     * this.model.input = input  and
     * this.model.output = input  and
     * [this.view has been updated to match this.model]
     * </pre>
     */
    void processCopyEvent(String input);

}
