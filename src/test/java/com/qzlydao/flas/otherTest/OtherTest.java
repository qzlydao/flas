package com.qzlydao.flas.otherTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testList() throws Exception {
        List list1 = new ArrayList();
        list1.add("1");

        List list2 = list1;

        System.out.println(list1);
        System.out.println(list2);

        list1.add("2");
        System.out.println(list1);
        System.out.println(list2);
    }

}
