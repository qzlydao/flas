package com.qzlydao.flas.otherTest;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liuqiang
 * Date: 2019-02-17 20:02
 */
public class OtherTest {

    @Test
    public void test1() throws Exception {
        String str1 = "aaaa";
        String str2 = "aaaa";

        String str3 = new String("bbbb");
        String str4 = new String("bbbb");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));

    }

}
