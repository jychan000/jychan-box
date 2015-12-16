package com.jychan.box.invoke;

import java.lang.reflect.Method;

/**
 * @author chenjinying
 * @version 15/12/15 22:06
 *          email:415683089@qq.com
 */
public class User {

    public void use(Method method) {
        Tool tool = new Tool();
        try {
            method.invoke(tool, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Control control = new Control();
        control.invoke(2);
    }
}
