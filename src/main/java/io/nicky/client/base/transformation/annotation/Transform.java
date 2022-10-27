package io.nicky.client.base.transformation.annotation;

import java.lang.annotation.*;

@Documented @SuppressWarnings("unused")
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface Transform {

    String[] method();
    Position position() default @Position;
    boolean cancellable() default false;

}
