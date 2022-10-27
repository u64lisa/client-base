package io.nicky.client.base.module.impl;

import io.nicky.client.base.module.Module;
import io.nicky.client.base.module.ModuleDescriptor;

@ModuleDescriptor(
        name = "Example",
        description = "This is the example module",
        bind = -1,
        state = ModuleDescriptor.DevelopingState.STABLE,
        active = true
)
public final class ExampleModule extends Module {

    @Override
    public void activate() {

    }

}
