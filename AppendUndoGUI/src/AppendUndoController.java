/**
 * Controller interface.
 * 
 * @author Bruce W. Weide
 * @author Paolo Bucci
 * 
 * @mathmodel <pre>
 * {@code type AppendUndoController is modeled by
 *   (model: AppendUndoModel,
 *    view: AppendUndoView)}
 * </pre>
 * @initially <pre>
 * {@code (AppendUndoModel model, AppendUndoView view):
 *   ensures
 *     this.model = model  and
 *     this.view = view}
 * </pre>
 */
public interface AppendUndoController {

    /**
     * Processes event to reset model.
     * 
     * @updates {@code this.model, this.view}
     * @ensures <pre>
     * {@code this.model.input = ""  and
     * this.model.output = <>  and
     * [this.view has been updated to match this.model]}
     * </pre>
     */
    void processResetEvent();

    /**
     * Processes event to append to output.
     * 
     * @param input
     *            string to be appended
     * 
     * @updates {@code this.model, this.view}
     * @ensures <pre>
     * {@code this.model.input = ""  and
     * this.model.output =  <input> * #this.model.output  and
     * [this.view has been updated to match this.model]}
     * </pre>
     */
    void processAppendEvent(String input);

    /**
     * Processes event to undo last append to output.
     * 
     * @updates {@code this.model, this.view}
     * @requires <pre>
     * {@code this.model.output /= <>}
     * </pre>
     * @ensures <pre>
     * {@code #this.model.output = <this.model.input> * this.model.output  and
     * [this.view has been updated to match this.model]}
     * </pre>
     */
    void processUndoEvent();

}
