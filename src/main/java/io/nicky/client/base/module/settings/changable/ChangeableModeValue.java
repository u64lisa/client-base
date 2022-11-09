package io.nicky.client.base.module.settings.changable;

import io.nicky.client.base.module.Module;
import io.nicky.client.base.module.settings.changable.exception.InvalidValueException;

import java.lang.reflect.Field;
import java.util.Arrays;

public final class ChangeableModeValue extends ChangeableValue {

    private final String[] possible;
    private String value;

    public ChangeableModeValue(final Module owner, final Field field, final String name,
                               String[] possible, String value) {
        super(owner, field, name);
        this.possible = possible;
        this.value = value;
    }

    public String[] getPossible() {
        return possible;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (Arrays.stream(this.getPossible()).noneMatch(s -> s.equalsIgnoreCase(value)))
            throw new InvalidValueException("Mode value for " + this.getName() + " did not match possible values, provided: " + value);

        this.value = value;
    }

    @Override
    public void update() throws Throwable {
        this.getLocalField().setAccessible(true);
        this.getLocalField().set(getOwner(), this.value);
    }
}
