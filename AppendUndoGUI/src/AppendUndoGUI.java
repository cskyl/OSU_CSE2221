/**
 * Simple GUI application supporting append and undo using a version of the
 * Model-View-Controller (MVC) design pattern including interfaces.
 * 
 * @author Bruce W. Weide
 * @author Paolo Bucci
 */
public final class AppendUndoGUI {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private AppendUndoGUI() {
    }

    /**
     * Main program that sets up main application window and starts user
     * interaction.
     * 
     * @param args
     *            command-line arguments; not used
     */
    public static void main(String[] args) {
        /*
         * Create instances of the model, view, and controller objects, and
         * initialize them; view needs to know about controller, and controller
         * needs to know about model and view
         */
        AppendUndoModel model = new AppendUndoModel1();
        AppendUndoView view = new AppendUndoView1();
        AppendUndoController controller = new AppendUndoController1(model, view);

        view.registerObserver(controller);
    }

}
