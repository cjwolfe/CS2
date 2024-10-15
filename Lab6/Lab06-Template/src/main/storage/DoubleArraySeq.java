package storage;
public class DoubleArraySeq {
    private static final int DEFAULT_CAPACITY = 10;
    private double[] data;
    private int manyItems;
    private int currentIndex;

    public DoubleArraySeq() {
        this(DEFAULT_CAPACITY);
    }

    public DoubleArraySeq(int initialCapacity) {
        data = new double[initialCapacity];
        manyItems = 0;
        currentIndex = 0;
    }

    public void addAfter(double element) {
        // TODO: Implement the addAfter method
    }
}
