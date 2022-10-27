package io.nicky.client.base.units;

public final class Counter {
    private final int baseValue;

    private int count;

    public Counter(final int baseValue) {
        this.baseValue = baseValue;
        this.count = baseValue;
    }

    public int getAndIncrease() {
        return count++;
    }

    public int get() {
        return this.count;
    }

    public void reset() {
        this.count = baseValue;
    }
}
