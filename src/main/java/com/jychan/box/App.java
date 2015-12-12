package com.jychan.box;


import java.util.Calendar;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Raymond
 * @version 15/12/5 18:33 .
 * @E-mail:415683089@qq.com
 */
public class App {

    private static String randomStr(int len) {
        StringBuilder sb = new StringBuilder(len);
        for(int i=0; i<len; i++) {
            int index = ThreadLocalRandom.current().nextInt(55, 91);
            if (index < 65)
                index -= 7;
            sb.append((char) index);
        }
        return sb.toString();
    }

    public static void main( String[] args ) {


        for(int i=0; i<100; i++) {
            System.out.println(randomStr(10));
        }

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        System.out.println(year + "-" + month + "-" + day);

    }
}
