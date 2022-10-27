package io.nicky.client.base.event.defaults;

import io.nicky.client.base.event.Event;

/**
 * The type Bus debugging event.
 * @param <T> the type parameter
 */
public record BusDebuggingEvent<T extends Event>(T event) implements Event {}
