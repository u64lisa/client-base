package io.nicky.client.base.module.settings;

import io.nicky.client.base.module.Module;
import io.nicky.client.base.module.settings.annotation.*;
import io.nicky.client.base.module.settings.changable.*;
import io.nicky.client.base.module.settings.exceptions.SettingsIndentException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class SettingsManager {

    private final List<ChangeableValue> changeableValues = new ArrayList<>();

    public void registerSettings(final Class<? extends Module> clazz, final Module module) {
        final List<Field> fieldList = Arrays.stream(clazz.getDeclaredFields()).filter(field -> field.getDeclaredAnnotations().length == 1).toList();

        try {
            for (final Field declaredField : fieldList) {
                final Annotation annotation = declaredField.getAnnotations()[0];

                if (annotation instanceof ModeValue value) {
                    if (!declaredField.getType().equals(String.class))
                        throw new SettingsIndentException("invalid type for setting expected: " + String.class.getName());

                    declaredField.setAccessible(true);
                    declaredField.set(module, value.defaultValue());

                    changeableValues.add(new ChangeableModeValue(module, declaredField, value.description().name(), value.values(), value.defaultValue()));
                }
                if (annotation instanceof CheckBoxValue value) {
                    if (!declaredField.getType().equals(boolean.class))
                        throw new SettingsIndentException("invalid type for setting expected: " + boolean.class.getName());

                    declaredField.setAccessible(true);
                    declaredField.set(module, value.defaultValue());

                    changeableValues.add(new ChangeableCheckBoxValue(module, declaredField, value.description().name(), value.defaultValue()));
                }
                if (annotation instanceof ColorValue value) {
                    if (!declaredField.getType().equals(int.class))
                        throw new SettingsIndentException("invalid type for setting expected: " + int.class.getName());

                    declaredField.setAccessible(true);
                    declaredField.set(module, value.defaultValue());

                    changeableValues.add(new ChangeableColorValue(module, declaredField, value.description().name(), value.defaultValue()));
                }
                if (annotation instanceof NumberValue value) {
                    if (!declaredField.getType().equals(double.class))
                        throw new SettingsIndentException("invalid type for setting expected: " + double.class.getName());

                    declaredField.setAccessible(true);
                    declaredField.set(module, value.defaultValue());

                    changeableValues.add(new ChangeableNumberValue(module, declaredField, value.description().name(), value.maxValue(), value.minValue(), value.defaultValue()));
                }
                if (annotation instanceof StringValue value) {
                    if (!declaredField.getType().equals(String.class))
                        throw new SettingsIndentException("invalid type for setting expected: " + String.class.getName());

                    declaredField.setAccessible(true);
                    declaredField.set(module, value.defaultValue());

                    changeableValues.add(new ChangeableStringValue(module, declaredField, value.description().name(), value.defaultValue()));
                }
            }
        } catch (final Throwable throwable) {
            throw new SettingsIndentException("Error while setting default value!");
        }

    }

    public List<ChangeableValue> forModule(final Module module) {
        return this.changeableValues.stream()
                .filter(changeableValue -> changeableValue.getOwner().getClass().equals(module.getClass()))
                .toList();
    }

}
