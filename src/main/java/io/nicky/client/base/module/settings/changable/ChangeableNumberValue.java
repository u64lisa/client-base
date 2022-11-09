package io.nicky.client.base.module.settings.changable;

import io.nicky.client.base.module.Module;

import java.lang.reflect.Field;

public class ChangeableNumberValue extends ChangeableValue {

    private final double max, min;
    private double value;

    public ChangeableNumberValue(Module owner, Field field, String name, double max, double min, double value) {
        super(owner, field, name);
        this.max = max;
        this.min = min;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if (value > max)
            value = max;

        if (value < min)
            value = min;

        this.value = value;
    }

    @Override
    public void update() throws Throwable {
        this.getLocalField().set(this.getOwner(), value);
    }
}
