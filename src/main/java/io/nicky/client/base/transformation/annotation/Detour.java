package io.nicky.client.base.transformation.annotation;

import java.lang.annotation.*;

@Documented
@SuppressWarnings("unused")
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Detour {
    String[] method();
    Position position() default @Position;
    boolean cancellable() default false;
}
