package com.cmb.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogInfo {

    String value() default "";
    boolean check() default false;
}
