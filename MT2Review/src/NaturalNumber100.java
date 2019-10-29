import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

public class NaturalNumber100 extends NaturalNumber2 {
    public boolean isOdd() {
        boolean odd = false;
        int number;
        number = this.divideBy10();
        odd = number % 2 == 1 ? true : false;
        return odd;
    }

    NaturalNumber100(int i) {
        super(i);
    }

    NaturalNumber100(String str) {
        super(str);
    }

    NaturalNumber100(NaturalNumber n) {
        super(n);
    }
}
