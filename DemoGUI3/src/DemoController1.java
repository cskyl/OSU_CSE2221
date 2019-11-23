/**
 * Controller class.
 * 
 * @author Bruce W. Weide
 * @author Paolo Bucci
 */
public final class DemoController1 implements DemoController {

    /**
     * Model object.
     */
    private final DemoModel model;

    /**
     * View object.
     */
    private final DemoView view;

    /**
     * Updates view to display model.
     * 
     * @param model
     *            the model
     * @param view
     *            the view
     */
    private static void updateViewToMatchModel(DemoModel model, DemoView view) {
        /*
         * Get model info
         */
        String input = model.input();
        String output = model.output();
        /*
         * Update view to reflect changes in model
         */
        view.updateInputDisplay(input);
        view.updateOutputDisplay(output);
    }

    /**
     * Constructor; connects {@code this} to the model and view it coordinates.
     * 
     * @param model
     *            model to connect to
     * @param view
     *            view to connect to
     */
    public DemoController1(DemoModel model, DemoView view) {
        this.model = model;
        this.view = view;
        /*
         * Update view to reflect initial value of model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    /**
     * Processes reset event.
     */
    @Override
    public void processResetEvent() {
        /*
         * Update model in response to this event
         */
        this.model.setInput("");
        this.model.setOutput("");
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

    /**
     * Processes copy event.
     * 
     * @param input
     *            value of input text (provided by view)
     */
    @Override
    public void processCopyEvent(String input) {
        /*
         * Update model in response to this event
         */
        this.model.setInput(input);
        this.model.setOutput(input);
        /*
         * Update view to reflect changes in model
         */
        updateViewToMatchModel(this.model, this.view);
    }

}
