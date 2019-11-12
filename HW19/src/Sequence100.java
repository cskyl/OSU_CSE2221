
public class Sequence100<T> extends Sequence99<T> {
    Sequence100() {
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
        if (this.length() > 1) {
            T top = this.remove(this.length() - 1);
            this.flip();
            this.add(0, top);
        }
    }
}
