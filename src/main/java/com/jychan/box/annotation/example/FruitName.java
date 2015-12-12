package com.jychan.box.annotation.example;

import java.lang.annotation.*;

/**
 * @author chenjinying
 * @version 15/12/9 13:50
 * email:415683089@qq.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
