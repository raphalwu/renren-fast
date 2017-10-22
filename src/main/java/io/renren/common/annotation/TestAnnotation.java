package io.renren.common.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAnnotation {

    String desc() default "没有标准描述";

    boolean view() default true;

    String operationDesc() default "没有默认描述";
}