package io.nicky.client.base.module.settings.annotation;

import io.nicky.client.base.module.settings.ValueDescriptor;

import java.lang.annotation.*;

@Documented
@SuppressWarnings("unused")
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberValue {

    ValueDescriptor description();

    double defaultValue();

    double minValue() default 0;
    double maxValue() default 100;
    double stepSize() default 0.2;

}
