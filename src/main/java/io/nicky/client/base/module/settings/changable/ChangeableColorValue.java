package io.nicky.client.base.module.settings.changable;

import io.nicky.client.base.module.Module;

import java.lang.reflect.Field;

public class ChangeableColorValue extends ChangeableValue {

    private int rgbColor;

    public ChangeableColorValue(Module owner, Field field, String name, int rgbColor) {
        super(owner, field, name);

        this.rgbColor = rgbColor;
    }

    public int getRgbColor() {
        return rgbColor;
    }

    public void setRgbColor(int rgbColor) {
        this.rgbColor = rgbColor;
    }

    @Override
    public void update() throws Throwable {
        this.getLocalField().set(this.getOwner(), rgbColor);
    }

}
