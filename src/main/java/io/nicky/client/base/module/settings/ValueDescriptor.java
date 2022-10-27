package io.nicky.client.base.module.settings;

import java.lang.annotation.*;

@Documented @SuppressWarnings("unused")
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueDescriptor {

    String name();
    String description();

}
