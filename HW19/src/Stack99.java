import components.stack.Stack1L;

public class Stack99<T> extends Stack1L {

    Stack99() {
        super();
    }

    @Override
    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public void flip() {
        if (this.length() > 0) {
            T top = (T) this.pop();
            this.flip();

            this.addFromBottom(top);
        }
    }

    public void addFromBottom(T item) {
        if (this.length() == 0) {
            this.push(item);
        } else {
            T topItem = (T) this.pop();
            this.addFromBottom(topItem);

            this.push(item);
        }
    }
}
