package io.nicky.client.base.event;

/* The type Cancelable. */
public abstract class Cancelable {
    private boolean state;

    /**
     * Is canceled boolean.
     * @return the boolean
     */
    public final boolean isCanceled() {
        return state;
    }

    /**
     * Sets canceled.
     * @return the canceled
     */
    public final boolean setCanceled() {
        return this.state = true;
    }

    /**
     * Sets free.
     * @return the free
     */
    public final boolean setFree() {
        return this.state = false;
    }

    /**
     * Toggle boolean.
     * @return the boolean
     */
    public final boolean toggle() {
        return this.state = !this.state;
    }
}
