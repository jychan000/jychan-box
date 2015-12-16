package com.jychan.box.callback.demo1;

/**
 * @author chenjinying
 * @version 15/12/15 22:34
 *          email:415683089@qq.com
 */
public class CallHHH {

    public void execute(CallBackInterface action) {
        doBefort();
        action.doSth();
        doAfter();
    }

    public void doBefort() {
        System.out.println("do befort ...");
    }

    public void doAfter() {
        System.out.println("do after ...");
    }
}
