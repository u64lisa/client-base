package io.nicky.client.base.module.settings.changable;

import java.lang.reflect.Field;
import io.nicky.client.base.module.Module;

public abstract class ChangeableValue {

    private final Module owner;

    private final Field localField;
    private final String name;

    protected ChangeableValue(Module owner, Field field, String name) {
        this.owner = owner;
        this.localField = field;
        this.name = name;
    }

    public abstract void update() throws Throwable;

    public Module getOwner() {
        return owner;
    }

    public Field getLocalField() {
        return localField;
    }

    public String getName() {
        return name;
    }
}
