package io.nicky.client.base.transformation.annotation;

import java.lang.annotation.*;

@Documented
@SuppressWarnings("unused")
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Rewrite {
    String method();
}
