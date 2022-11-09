package io.nicky.client.base.module.settings.changable;

import io.nicky.client.base.module.Module;

import java.lang.reflect.Field;

public class ChangeableCheckBoxValue extends ChangeableValue {

    private boolean value;

    public ChangeableCheckBoxValue(Module owner, Field field, String name, boolean value) {
        super(owner, field, name);
        this.value = value;
    }

    protected ChangeableCheckBoxValue(Module owner, Field field, String name) {
        super(owner, field, name);
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    @Override
    public void update() throws Throwable {
        this.getLocalField().set(getOwner(), this.value);
    }
}
