package io.nicky.client.base.event;

import io.nicky.client.base.interfaces.Callback;
import io.nicky.client.base.interfaces.Supplier;

/**
 * The type Listener entry.
 * @param <T> the type parameter
 */
// @formatter:off
public record ListenerEntry<T extends Event>(long elementId, Class<T> element, Supplier<Boolean> supplier, Callback<T> event) {}
