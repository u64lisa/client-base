package io.nicky.client.base.event;

import io.nicky.client.base.event.defaults.BusDebuggingEvent;
import io.nicky.client.base.interfaces.Callback;
import io.nicky.client.base.interfaces.Cast;
import io.nicky.client.base.interfaces.Supplier;
import io.nicky.client.base.units.Counter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

/**
 * The type Event bus.
 */
@SuppressWarnings("all")
public final class EventBus implements IEventBus {

    private final List<ListenerEntry<? extends Event>> eventListener = new ArrayList<>();
    private final List<ListenerEntry<? extends Event>> alwaysCancelledEvents = new ArrayList<>();

    private final Random random = ThreadLocalRandom.current();

    private final Counter counter = new Counter(100);

    /**
     * The Debugging event consumer.
     */
    final Consumer<BusDebuggingEvent<? extends Event>> debuggingEventConsumer = event -> {
    };

    @Override
    public <T extends Event> void registerListener(final Class<T> element, final Supplier<Boolean> supplier, final Callback<T> event) {
        final int currentCount = this.counter.getAndIncrease();
        final long currentId = random.nextLong(10, currentCount);

        final ListenerEntry<T> listenerEntry = new ListenerEntry<>(
                currentId, element, supplier, event);

        this.eventListener.add(listenerEntry);
    }

    @Override
    public <T extends Event> void registerListener(final Class<T> element, final Callback<T> event) {
        final int currentCount = this.counter.getAndIncrease();
        final long currentId = random.nextLong(10, currentCount);

        final ListenerEntry<T> listenerEntry = new ListenerEntry<>(
                currentId, element, () -> true, event);

        this.eventListener.add(listenerEntry);
    }

    @Override
    public <T extends Event> T releaseEvent(T event) {
        if (event == null)
            return event;

        this.debuggingEventConsumer.accept(new BusDebuggingEvent<>(event));

        for (ListenerEntry<? extends Event> listenerEntry : this.eventListener) {
            if (listenerEntry.event() == null)
                continue;

            if (!listenerEntry.element().getName().equalsIgnoreCase(event.getClass().getName()))
                continue;

            if (!listenerEntry.supplier().supply())
                continue;

            listenerEntry.event().accept(Cast.perform(event));
        }

        for (ListenerEntry<? extends Event> alwaysCancelledEvent : alwaysCancelledEvents) {

        }

        return event;
    }

    @Override
    @SafeVarargs
    public final <T extends Event> void multiCancel(T... elements) {
        final int currentCount = this.counter.getAndIncrease();
        final long currentId = random.nextLong(10, currentCount);

        Arrays.stream(elements)
                .filter(t -> t instanceof Cancelable)
                .map(t -> (Cancelable) t)
                .forEachOrdered(cancelable -> this.alwaysCancelledEvents.add(new ListenerEntry<>(currentId,
                        Cast.perform(cancelable.getClass()), () -> true, element -> {
                    if (element instanceof Cancelable current)
                        current.setCanceled();
                })));
    }

    @Override
    public void clearListener() {
        this.eventListener.clear();
        this.alwaysCancelledEvents.clear();
    }

}
