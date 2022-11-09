package io.nicky.client.base.module.settings.annotation;

import io.nicky.client.base.module.settings.ValueDescriptor;

import java.lang.annotation.*;

@Documented
@SuppressWarnings("unused")
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StringValue {

    ValueDescriptor description();

    String defaultValue();

}
