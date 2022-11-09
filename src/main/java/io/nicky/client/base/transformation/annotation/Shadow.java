package io.nicky.client.base.transformation.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@SuppressWarnings("unused")
@Retention(RetentionPolicy.RUNTIME)
public @interface Shadow {
    boolean overrideAccess() default false;
}
