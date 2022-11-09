package io.nicky.client.base.module.impl;

import io.nicky.client.base.event.defaults.ModuleInitializeEvent;
import io.nicky.client.base.module.Module;
import io.nicky.client.base.module.ModuleDescriptor;
import io.nicky.client.base.module.settings.ValueDescriptor;
import io.nicky.client.base.module.settings.annotation.*;

import java.awt.*;

@ModuleDescriptor(
        name = "Example",
        description = "This is the example module",
        bind = -1,
        state = ModuleDescriptor.DevelopingState.STABLE,
        active = true
)
public final class ExampleModule extends Module {

    @CheckBoxValue(
            defaultValue = true,
            description = @ValueDescriptor(
                    name = "example",
                    description = "this is the example check box"
            )
    )
    private boolean exampleCheckBox;

    @ColorValue(
            defaultValue = 500,
            description = @ValueDescriptor(
                    name = "example",
                    description = "this is the example color picker"
            )
    )
    private int exampleColor;

    @ModeValue(
            defaultValue = "mode_1",
            values = {"mode_1", "mode_2"},
            description = @ValueDescriptor(
                    name = "example",
                    description = "this is the example mode picker"
            )
    )
    private String exampleMode;

    @NumberValue(
            defaultValue = 50,
            maxValue = 100,
            minValue = 0,
            stepSize = 0.5,
            description = @ValueDescriptor(
                    name = "example",
                    description = "this is the example slider"
            )
    )
    private double exampleSlider;

    @StringValue(
            defaultValue = "Enter text...",
            description = @ValueDescriptor(
                    name = "example",
                    description = "this is the example textbox"
            )
    )
    private String exampleTextBox;


    @Override
    public void activate() {
        this.getEventBus().registerListener(ModuleInitializeEvent.class, this, event -> {

            System.out.println("event called owo");

        });
    }

}
