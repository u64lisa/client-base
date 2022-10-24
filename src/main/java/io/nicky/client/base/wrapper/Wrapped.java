package io.nicky.client.base.wrapper;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@SuppressWarnings("unused")
@Retention(RetentionPolicy.RUNTIME)
public @interface Wrapped {

    String original();

}
