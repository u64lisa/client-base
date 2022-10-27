package io.nicky.client.base.math.timer;

/**
 * @author FooFieOwO, lumii500pg
 */
public final class TickTimer extends Timer {
    private long ticks = 0;

    @Override
    public void reset() {
        this.ticks = 0;
    }

    @Override
    public long getTime() {
        this.ticks++;
        return this.ticks;
    }

    @Override
    public void setTime(final long ticks) {
        this.ticks = ticks;
    }

    @Override
    public long getElapsedTime() {
        return this.getTime();
    }

    @Override
    public boolean elapsed(final long ticks) {
        return this.getTime() > ticks;
    }
}
