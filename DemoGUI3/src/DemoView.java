import java.awt.event.ActionListener;

/**
 * View interface.
 * 
 * @author Bruce W. Weide
 * @author Paolo Bucci
 */
public interface DemoView extends ActionListener {

    /**
     * Register argument as observer/listener of this; this must be done first,
     * before any other methods of this class are called.
     * 
     * @param controller
     *            controller to register
     */
    void registerObserver(DemoController controller);

    /**
     * Updates input display based on String provided as argument.
     * 
     * @param input
     *            new value of input display
     */
    void updateInputDisplay(String input);

    /**
     * Updates output display based on String provided as argument.
     * 
     * @param output
     *            new value of output display
     */
    void updateOutputDisplay(String output);

}
