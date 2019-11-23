/**
 * Controller interface.
 *
 * @author Bruce W. Weide
 *
 * @mathmodel <pre>
 * type NNCalcController is modeled by
 *   (model: NNCalcModel,
 *    view: NNCalcView)
 * </pre>
 * @initially <pre>
 * (NNCalcModel model, NNCalcView view):
 *   ensures
 *     this.model = model  and
 *     this.view = view
 * </pre>
 */
public interface NNCalcController {

    /**
     * Processes event to clear bottom operand.
     *
     * @updates this.model.bottom, this.view
     * @ensures <pre>
     * this.model.bottom = 0  and
     * [this.view has been updated to match this.model]
     * </pre>
     */
    void processClearEvent();

    /**
     * Processes event to swap operands.
     *
     * @updates this.model, this.view
     * @ensures <pre>
     * this.model.top = #this.model.bottom  and
     * this.model.bottom = #this.model.top  and
     * [this.view has been updated to match this.model]
     * </pre>
     */
    void processSwapEvent();

    /**
     * Processes event to enter bottom operand to top.
     *
     * @updates this.model.top, this.view
     * @ensures <pre>
     * this.model.top = this.model.bottom  and
     * [this.view has been updated to match this.model]
     * </pre>
     */
    void processEnterEvent();

    /**
     * Processes event to do an add operation.
     *
     * @updates this.model, this.view
     * @ensures <pre>
     * this.model.top = 0  and
     * this.model.bottom = #this.model.top + #this.model.bottom  and
     * [this.view has been updated to match this.model]
     * </pre>
     */
    void processAddEvent();

    /**
     * Processes event to do a subtract operation.
     *
     * @updates this.model, this.view
     * @requires this.model.bottom <= this.model.top
     * @ensures <pre>
     * this.model.top = 0  and
     * this.model.bottom = #this.model.top - #this.model.bottom  and
     * [this.view has been updated to match this.model]
     * </pre>
     */
    void processSubtractEvent();

    /**
     * Processes event to do a multiply operation.
     *
     * @updates this.model, this.view
     * @ensures <pre>
     * this.mode.top = 0  and
     * this.model.bottom = #this.model.top * #this.model.bottom  and
     * [this.view has been updated to match this.model]
     * </pre>
     */
    void processMultiplyEvent();

    /**
     * Processes event to do a divide operation.
     *
     * @updates this.model, this.view
     * @requires this.model.bottom > 0
     * @ensures <pre>
     * #this.model.top =
     *   this.model.bottom * #this.model.bottom + this.model.top  and
     * 0 <= this.model.top < #this.model.bottom  and
     * [this.view has been updated to match this.model]
     * </pre>
     */
    void processDivideEvent();

    /**
     * Processes event to do a power operation.
     *
     * @updates this.model, this.view
     * @requires this.model.bottom <= INT_LIMIT
     * @ensures <pre>
     * this.model.top = 0  and
     * this.model.bottom = #this.model.top ^ (#this.model.bottom)  and
     * [this.view has been updated to match this.model]
     * </pre>
     */
    void processPowerEvent();

    /**
     * Processes event to do a root operation.
     *
     * @updates this.model, this.view
     * @requires 2 <= this.model.bottom <= INT_LIMIT
     * @ensures <pre>
     * this.model.top = 0  and
     * this.model.bottom =
     *   [the floor of the #this.model.bottom root of #this.model.top]  and
     * [this.view has been updated to match this.model]
     * </pre>
     */
    void processRootEvent();

    /**
     * Processes event to add a new (low-order) digit to the bottom operand.
     *
     * @param digit
     *            the low-order digit to be added
     *
     * @updates this.model.bottom, this.view
     * @requires 0 <= digit < 10
     * @ensures <pre>
     * this.model.bottom = #this.model.bottom * 10 + digit  and
     * [this.view has been updated to match this.model]
     * </pre>
     */
    void processAddNewDigitEvent(int digit);

}
