package storage;
public class DoubleArraySeq implements Cloneable {
    public static final int DEFAULT_CAPACITY = 10;
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
        ensureCapacity(manyItems + 1);
        if (isCurrent()) {
            for (int i = manyItems; i > currentIndex + 1; i--) {
                data[i] = data[i - 1];
            }
            data[currentIndex + 1] = element;
            currentIndex++;
        } else {
            data[manyItems] = element;
            currentIndex = manyItems;
        }
        manyItems++;
    }
    
    public void addBefore(double element) {
        ensureCapacity(manyItems + 1);
        if (isCurrent()) {
            for (int i = manyItems; i > currentIndex; i--) {
                data[i] = data[i - 1];
            }
        } else {
            currentIndex = 0;
            for (int i = manyItems; i > currentIndex; i--) {
                data[i] = data[i - 1];
            }
        }
        data[currentIndex] = element;
        manyItems++;
    }

    public void addAll(DoubleArraySeq addend) {
        int newCapacity = manyItems + addend.manyItems;
        ensureCapacity(newCapacity);
        for (int i = 0; i < addend.manyItems; i++) {
            data[manyItems + i] = addend.data[i];
        }
        manyItems += addend.manyItems;
    }

    public void trimToSize() {
        double[] newData = new double[manyItems];
        for (int i = 0; i < manyItems; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void ensureCapacity(int minimumCapacity) {
        if (data.length < minimumCapacity) {
            double[] newData = new double[minimumCapacity];
            for (int i = 0; i < manyItems; i++) {
                newData[i] = data[i];
            }
            if (minimumCapacity > data.length) {
                data = newData;
            }
        }
    }

    public void start() {
        currentIndex = 0;
    }

    public void advance() {
        if (isCurrent()) {
            currentIndex++;
        } else {
            throw new IllegalStateException("No current element, advance");
        }
    }

    public double getCurrent() {
        if (isCurrent()) {
            return data[currentIndex];
        } else {
            throw new IllegalStateException("No current element");
        }
    }

    public void removeCurrent() {
        if (isCurrent()) {
            for (int i = currentIndex; i < manyItems - 1; i++) {
                data[i] = data[i + 1];
            }
            manyItems--;
        } else {
            throw new IllegalStateException("Illegal State");
        }
    }

    public boolean isCurrent() {
        return currentIndex >= 0 && currentIndex < manyItems;
    }

    public int getCapacity() {
        return data.length;
    }

    public int size() {
        return manyItems;
    }

    @Override
    public DoubleArraySeq clone() {
        DoubleArraySeq clone = new DoubleArraySeq(data.length);
        clone.manyItems = manyItems;
        clone.currentIndex = currentIndex;
        for (int i = 0; i < manyItems; i++) {
            clone.data[i] = data[i];
        }
        return clone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < manyItems; i++) {
            if (i == currentIndex) {
                sb.append("[").append(data[i]).append("]");
            } else {
                sb.append("<").append(data[i]).append(">");
            }
            if (i < manyItems - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        return sb.toString();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DoubleArraySeq otherSeq = (DoubleArraySeq) other;
        if (manyItems != otherSeq.manyItems || currentIndex != otherSeq.currentIndex) {
            return false;
        }
        for (int i = 0; i < manyItems; i++) {
            if (data[i] != otherSeq.data[i]) {
                return false;
            }
        }
        return true;
    }

    public static DoubleArraySeq concatenation(DoubleArraySeq s1, DoubleArraySeq s2) {
        DoubleArraySeq result = new DoubleArraySeq(s1.manyItems + s2.manyItems);
        for (int i = 0; i < s1.manyItems; i++) {
            result.data[i] = s1.data[i];
        }
        for (int i = 0; i < s2.manyItems; i++) {
            result.data[s1.manyItems + i] = s2.data[i];
        }
        result.manyItems = s1.manyItems + s2.manyItems;
        return result;
    }
}
