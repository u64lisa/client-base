package io.nicky.client.base.module;

import java.lang.annotation.*;

@Documented
@SuppressWarnings("unused")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleDescriptor {

    String name();
    String description();
    int bind();

    DevelopingState state();
    boolean active();

    enum DevelopingState {
        STABLE,
        UNSTABLE,
        ;
    }

}
