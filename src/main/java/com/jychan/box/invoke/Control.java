package com.jychan.box.invoke;

/**
 * @author chenjinying
 * @version 15/12/15 22:05
 *          email:415683089@qq.com
 */
public class Control {

    public void invoke(int flag) {
        User user = new User();
        try {
            switch (flag) {
                case 0:
                    user.use(Tool.class.getMethod("a", null));
                    break;
                default:
                    user.use(Tool.class.getMethod("b", null));
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
