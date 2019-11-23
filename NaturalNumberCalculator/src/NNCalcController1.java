import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * Controller class.
 *
 * @author Tony Han
 */
public final class NNCalcController1 implements NNCalcController {

    /**
     * Model object.
     */
    private final NNCalcModel model;

    /**
     * View object.
     */
    private final NNCalcView view;

    /**
     * Useful constants.
     */
    private static final NaturalNumber TWO = new NaturalNumber2(2),
            INT_LIMIT = new NaturalNumber2(Integer.MAX_VALUE);
    private static final NaturalNumber ZERO = new NaturalNumber2();

    /**
     * Updates this.view to display this.model, and to allow only operations
     * that are legal given this.model.
     *
     * @param model
     *            the model
     * @param view
     *            the view
     * @ensures [view has been updated to be consistent with model]
     */
    private static void updateViewToMatchModel(NNCalcModel model,
            NNCalcView view) {

        NaturalNumber inputNN = model.bottom();
        NaturalNumber outputNN = model.top();

        view.updateBottomDisplay(inputNN);
        view.updateTopDisplay(outputNN);

        if (model.bottom().compareTo(ZERO) > 0) {
            view.updateDivideAllowed(true);
        } else {
            view.updateDivideAllowed(false);
        }

        if (model.bottom().compareTo(outputNN) < 0) {
            view.updateSubtractAllowed(true);
        } else {
            view.updateSubtractAllowed(false);
        }

        if (model.bottom().compareTo(INT_LIMIT) < 0) {
            view.updatePowerAllowed(true);
        } else {
            view.updatePowerAllowed(false);
        }

        if (model.bottom().compareTo(TWO) >= 0
                && model.bottom().compareTo(INT_LIMIT) <= 0) {
            view.updateRootAllowed(true);
        } else {
            view.updateRootAllowed(false);
        }
    }

    /**
     * Constructor.
     *
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public NNCalcController1(NNCalcModel model, NNCalcView view) {
        this.model = model;
        this.view = view;
        updateViewToMatchModel(model, view);
    }

    @Override
    public void processClearEvent() {
        /*
         * Get alias to bottom from model
         */
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        bottom.clear();
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processSwapEvent() {
        /*
         * Get aliases to top and bottom from model
         */
        NaturalNumber top = this.model.top();
        NaturalNumber bottom = this.model.bottom();
        /*
         * Update model in response to this event
         */
        NaturalNumber temp = top.newInstance();
        temp.transferFrom(top);
        top.transferFrom(bottom);
        bottom.transferFrom(temp);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processEnterEvent() {

        NaturalNumber nnTop = this.model.top();
        NaturalNumber nnBottom = this.model.bottom();

        nnTop.copyFrom(nnBottom);

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processAddEvent() {

        NaturalNumber nnTop = this.model.top();
        NaturalNumber nnBottom = this.model.bottom();

        nnBottom.add(nnTop);
        nnTop.clear();

        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processSubtractEvent() {

        NaturalNumber nnTop = this.model.top();
        NaturalNumber nnBottom = this.model.bottom();

        nnTop.subtract(nnBottom);
        nnBottom.transferFrom(nnTop);

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processMultiplyEvent() {

        NaturalNumber nnTop = this.model.top();
        NaturalNumber nnBottom = this.model.bottom();

        nnBottom.multiply(nnTop);
        nnTop.clear();

        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processDivideEvent() {

        NaturalNumber nnTop = this.model.top();
        NaturalNumber nnBottom = this.model.bottom();

        NaturalNumber r = nnTop.divide(nnBottom);
        nnBottom.transferFrom(nnTop);
        nnTop.transferFrom(r);

        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processPowerEvent() {

        NaturalNumber nnTop = this.model.top();
        NaturalNumber nnBottom = this.model.bottom();

        nnTop.power(nnBottom.toInt());
        nnBottom.transferFrom(nnTop);

        updateViewToMatchModel(this.model, this.view);
    }

    @Override
    public void processRootEvent() {

        NaturalNumber nnTop = this.model.top();
        NaturalNumber nnBottom = this.model.bottom();

        nnTop.root(nnBottom.toInt());
        nnBottom.transferFrom(nnTop);

        updateViewToMatchModel(this.model, this.view);

    }

    @Override
    public void processAddNewDigitEvent(int digit) {

        NaturalNumber bottom = this.model.bottom();

        bottom.multiplyBy10(digit);

        updateViewToMatchModel(this.model, this.view);
    }

}
