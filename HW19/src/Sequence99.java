import java.util.Iterator;

import components.sequence.Sequence;
import components.sequence.Sequence1L;

public class Sequence99<T> extends Sequence1L<T> {
    Sequence99() {
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
        Sequence<T> tempSequence = new Sequence99();
        tempSequence.transferFrom(this);
        for (Iterator<T> iter = tempSequence.iterator(); iter.hasNext();) {
            T item = iter.next();
            this.add(0, item);
        }
    }
}
