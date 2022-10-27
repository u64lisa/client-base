package io.nicky.client.base.transformation.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@SuppressWarnings("unused")
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
    String className() default "none";
    Class<?> clazz() default Inject.class;
}
