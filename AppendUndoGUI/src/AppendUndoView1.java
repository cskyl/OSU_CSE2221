import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public final class AppendUndoView1 extends JFrame implements AppendUndoView {

    private AppendUndoController controller;

    private static final int LINES_IN_TEXT_AREAS = 5,
            LINE_LENGTHS_IN_TEXT_AREAS = 20, ROWS_IN_BUTTON_PANEL_GRID = 1,
            COLUMNS_IN_BUTTON_PANEL_GRID = 2, ROWS_IN_THIS_GRID = 3,
            COLUMNS_IN_THIS_GRID = 1;

    private final JTextArea inputText, outputText;

    private final JButton AppendButton, ResetButton, UndoButton;

    public AppendUndoView1() {
        super("Simple Append/Undo GUI");

        this.inputText = new JTextArea("", LINES_IN_TEXT_AREAS,
                LINE_LENGTHS_IN_TEXT_AREAS);
        this.outputText = new JTextArea("", LINES_IN_TEXT_AREAS,
                LINE_LENGTHS_IN_TEXT_AREAS);

        this.AppendButton = new JButton("Append");
        this.ResetButton = new JButton("Reset");
        this.UndoButton = new JButton("Undo");

        this.inputText.setEditable(true);
        this.inputText.setLineWrap(true);
        this.inputText.setWrapStyleWord(true);
        this.outputText.setEditable(false);
        this.outputText.setLineWrap(true);
        this.outputText.setWrapStyleWord(true);

        JScrollPane inputTextScrollPane = new JScrollPane(this.inputText);
        JScrollPane outputTextScrollPane = new JScrollPane(this.outputText);

        JPanel buttonPanel = new JPanel(new GridLayout(
                ROWS_IN_BUTTON_PANEL_GRID, COLUMNS_IN_BUTTON_PANEL_GRID));

        buttonPanel.add(this.ResetButton);
        buttonPanel.add(this.AppendButton);
        buttonPanel.add(this.UndoButton);

        this.setLayout(new GridLayout(ROWS_IN_THIS_GRID, COLUMNS_IN_THIS_GRID));

        this.add(inputTextScrollPane);
        this.add(buttonPanel);
        this.add(outputTextScrollPane);

        this.ResetButton.addActionListener(this);
        this.AppendButton.addActionListener(this);
        this.UndoButton.addActionListener(this);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        Object source = event.getSource();
        if (source == this.ResetButton) {
            this.controller.processResetEvent();
        } else if (source == this.AppendButton) {
            this.controller.processAppendEvent(this.inputText.getText());
        } else if (source == this.UndoButton) {
            this.controller.processUndoEvent();
        }

        this.setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void registerObserver(AppendUndoController controller) {
        this.controller = controller;

    }

    @Override
    public void updateInputDisplay(String input) {
        this.inputText.setText(input);

    }

    @Override
    public void updateOutputDisplay(String output) {
        this.outputText.setText(output);

    }

    @Override
    public void updateUndoAllowed(boolean allowed) {
        this.UndoButton.setEnabled(allowed);

    }

}
