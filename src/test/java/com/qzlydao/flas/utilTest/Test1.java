package com.qzlydao.flas.utilTest;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liuqiang
 * Date: 2019-02-01 17:56
 */
public class Test1 {

    @Test
    public void test_A() throws Exception {
        int a = Integer.SIZE-3;
        int b  = -1 << a;

        System.out.println(a);
        System.out.println(b);


    }

    @Test
    public void test() throws Exception {

        int i = Runtime.getRuntime().availableProcessors();

    }



}
