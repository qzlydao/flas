package com.qzlydao.flas.thread.task;

import java.security.SecureRandom;
import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liuqiang
 * Date: 2019-02-03 14:06
 */
public class DemoTaskB implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int randomInt = new SecureRandom(new byte[1024]).nextInt(1000);
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName() + "--DemoTaskB--" + randomInt);
        return randomInt;
    }
}
