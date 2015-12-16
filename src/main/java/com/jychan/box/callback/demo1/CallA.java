package com.jychan.box.callback.demo1;

/**
 * @author chenjinying
 * @version 15/12/15 22:22
 *          email:415683089@qq.com
 */
public class CallA implements CallBackInterface {

    private CallHHH call;

    @Override
    public void doSth() {
        System.out.println("this is Call A ...");
    }

    public void add() {
        call.execute(new CallA());
    }

    public static void main(String[] args) {
        CallA calla = new CallA();
        calla.add();
    }
}
