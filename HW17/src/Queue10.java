import components.queue.Queue2;

public class Queue10<T> extends Queue2<T> {

    @Override
    /**
     * Reverses ("flips") {@code this}.
     *
     * @updates this
     * @ensures this = rev(#this)
     */
    public void flip() {
        if (this.length() != 0) {
            T temp = this.dequeue();
            this.flip();
            this.enqueue(temp);
        }
    }

}
