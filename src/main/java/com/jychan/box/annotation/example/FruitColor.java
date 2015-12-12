package com.jychan.box.annotation.example;

import java.lang.annotation.*;
/**
 * @author chenjinying
 * @version 15/12/9 13:53
 *          email:415683089@qq.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitColor {

    enum Color{ BULE,RED,GREEN};

    Color fruitColor() default Color.GREEN;
}
