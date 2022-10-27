package io.nicky.client.base.event.defaults;

import io.nicky.client.base.event.Event;
import io.nicky.client.base.module.ModuleDescriptor;

public record ModuleInitializeEvent(ModuleDescriptor descriptor) implements Event {
}
