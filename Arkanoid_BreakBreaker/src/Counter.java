// 206398596 Guy Reuveni

/**
 * this class creates a counter.
 *
 * @author Guy Reuveni.
 */
public class Counter {
    private int counter;

    /**
     * this is the constructor of the counter class.
     *
     * @param num an number.
     */
    public Counter(int num) {
        this.counter = num;
    }

    // add number to current count.

    /**
     * add number to current count.
     *
     * @param number a number.
     */
    public void increase(int number) {
        this.counter = this.counter + number;
    }

    /**
     * subtract number from current count.
     *
     * @param number a number.
     */
    public void decrease(int number) {

        this.counter = this.counter - number;
    }

    /**
     * this get current count.
     *
     * @return the value of the counter.
     */
    public int getValue() {
        return this.counter;
    }
}