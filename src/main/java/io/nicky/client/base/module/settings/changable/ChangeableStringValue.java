package io.nicky.client.base.module.settings.changable;

import io.nicky.client.base.module.Module;

import java.lang.reflect.Field;

public class ChangeableStringValue extends ChangeableValue {

    private String value;

    public ChangeableStringValue(Module owner, Field field, String name, String defaultValue) {
        super(owner, field, name);
        this.value = defaultValue;
    }

    public void setTextValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void update() throws Throwable {
        this.getLocalField().set(this.getOwner(), value);
    }
}
