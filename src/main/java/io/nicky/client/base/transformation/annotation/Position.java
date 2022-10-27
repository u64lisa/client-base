package io.nicky.client.base.transformation.annotation;

import io.nicky.client.base.transformation.targets.TargetType;

import java.lang.annotation.*;

@Documented
@SuppressWarnings("unused")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Position {

    TargetType type() default TargetType.HEAD;

    String target() default "";

    boolean optional() default false;

    enum TargetPosition {
        BEFORE,
        AFTER
    }

}
