package com.qzlydao.flas.thread.task;

import java.security.SecureRandom;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liuqiang
 * Date: 2019-02-03 14:16
 */
public class DemoTaskC implements Runnable {

    @Override
    public void run() {
        int i = new SecureRandom(new byte[1024]).nextInt(1000);
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
