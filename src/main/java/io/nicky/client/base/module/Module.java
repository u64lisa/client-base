package io.nicky.client.base.module;

import io.nicky.client.base.event.defaults.ModuleInitializeEvent;
import io.nicky.client.base.mapping.MappedValue;
import io.nicky.client.base.module.exceptions.ModuleInitializeException;

/**
 * The type Module.
 */
@SuppressWarnings("unused")
public abstract class Module {

    // state
    private boolean stateInternal;
    private final MappedValue<Boolean> state = new MappedValue<Boolean>()
            .setResolveMethod(() -> this.stateInternal)
            .setUpdateMethod(element -> this.stateInternal = element)
            .build();

    // bind
    private int bindInternal;
    private final MappedValue<Integer> bind = new MappedValue<Integer>()
            .setResolveMethod(() -> this.bindInternal)
            .setUpdateMethod(element -> this.bindInternal = element)
            .build();

    /**
     * Initialize.
     *
     * @param moduleManager the module manager
     */
    public final void initialize(final ModuleManager moduleManager) {
        final ModuleDescriptor descriptor = this.getClass()
                .getDeclaredAnnotation(ModuleDescriptor.class);

        if (descriptor == null)
            throw new ModuleInitializeException(this);

        moduleManager
                .registerNamed(this, descriptor);

        moduleManager.getSettingsManager()
                .registerSettings(this);

        moduleManager
                .getEventBus()
                .releaseEvent(new ModuleInitializeEvent(descriptor));

        this.bind.setValue(descriptor.bind());
        this.state.setValue(descriptor.active());
    }

    /**
     * Toggle.
     */
    public void toggle() {
        this.state.setValue(!this.state.getValue());
    }

    /**
     * Activate.
     */
    public void activate() {}

    /**
     * Deactivate.
     */
    public void deactivate() {}

    /**
     * Is active boolean.
     *
     * @return the boolean
     */
    public boolean isActive() {
        return this.state.getValue();
    }

    /**
     * Gets bind.
     *
     * @return the bind
     */
    public int getBind() {
        return this.bind.getValue();
    }

    /**
     * Sets bind.
     *
     * @param bind the bind
     */
    public void setBind(int bind) {
        this.bind.setValue(bind);
    }

}
