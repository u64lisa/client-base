package io.nicky.client.base.math.timer;

/**
 * @author FooFieOwO, lumii500pg
 */
public final class MSTimer extends Timer {
    private long millis = System.currentTimeMillis();

    @Override
    public void reset() {
        this.millis = System.currentTimeMillis();
    }

    @Override
    public long getTime() {
        return this.millis;
    }

    @Override
    public void setTime(final long time) {
        this.millis = time;
    }

    @Override
    public long getElapsedTime() {
        return System.currentTimeMillis() - this.millis;
    }

    @Override
    public boolean elapsed(final long time) {
        return System.currentTimeMillis() - this.millis > time;
    }
}
