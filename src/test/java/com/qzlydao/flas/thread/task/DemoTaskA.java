package com.qzlydao.flas.thread.task;

import java.security.SecureRandom;
import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liuqiang
 * Date: 2019-02-03 13:42
 */
public class DemoTaskA implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int randomInt = new SecureRandom(new byte[1024]).nextInt(10);
        System.out.println(randomInt);
        return randomInt;
    }
}
