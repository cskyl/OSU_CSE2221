import components.stack.Stack;
import components.stack.Stack1L;

public class AppendUndoModel1 implements AppendUndoModel {

    private String input;
    Stack<String> output = new Stack1L<String>();

    public AppendUndoModel1() {
        this.input = "";
        this.output.clear();
    }

    @Override
    public String input() {
        return this.input;
    }

    @Override
    public void setInput(String input) {
        this.input = input;
    }

    public void setOutput(String output) {
        this.output.push(output);
    }

    public void resetOutput() {
        this.output.clear();
    }

    @Override
    public Stack<String> output() {
        return this.output;
    }

}
