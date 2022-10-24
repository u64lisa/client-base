package io.nicky.client.base.event;

import io.nicky.client.base.interfaces.Callback;
import io.nicky.client.base.interfaces.Supplier;

/**
 * The interface Event bus.
 */
@SuppressWarnings({"all"})
public interface IEventBus {

    /**
     * Register listener.
     *
     * @param <T>      the type parameter
     * @param element  the element
     * @param supplier the supplier
     * @param event    the event
     */
    <T extends Event> void registerListener(Class<T> element, Supplier<Boolean> supplier, Callback<T> event);

    /**
     * Register listener.
     *
     * @param <T>     the type parameter
     * @param element the element
     * @param event   the event
     */
    <T extends Event> void registerListener(Class<T> element, Callback<T> event);

    /**
     * Release event t.
     *
     * @param <T>   the type parameter
     * @param event the event
     * @return the t
     */
    <T extends Event> T releaseEvent(final T event);

    /**
     * Multi cancel.
     *
     * @param <T>      the type parameter
     * @param elements the elements
     */
    <T extends Event> void multiCancel(final T... elements);

    /**
     * Clear listener.
     */
    void clearListener();
}
