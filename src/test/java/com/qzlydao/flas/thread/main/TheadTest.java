package com.qzlydao.flas.thread.main;

import com.qzlydao.flas.thread.task.DemoTaskA;
import com.qzlydao.flas.thread.task.DemoTaskB;
import com.qzlydao.flas.thread.task.DemoTaskC;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liuqiang
 * Date: 2019-02-03 13:37
 */
public class TheadTest {

    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    @Test
    public void test1() throws Exception {
        DemoTaskA task = new DemoTaskA();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        executorService.submit(futureTask);
        Thread.sleep(1000);
        Integer result = futureTask.get();
        System.out.println(result);
    }

    // ExecutorCompletionService
    @Test
    public void test2() throws Exception {
        DemoTaskB demoTaskB = new DemoTaskB();
        ExecutorCompletionService<Integer> service = new ExecutorCompletionService<>(executorService);
        Future<Integer> submit = service.submit(demoTaskB);
        Integer integer = submit.get();
        System.out.println(integer);

    }

    @Test
    public void test3() throws Exception {
        DemoTaskB taskB = new DemoTaskB();
        Future<Integer> submit = executorService.submit(taskB);
        Integer integer = submit.get();
        System.out.println(Thread.currentThread().getName() + "---" + integer);
    }

    @Test
    public void test4() throws Exception {
        DemoTaskC taskC = new DemoTaskC();
        // executorService.execute(taskC);
        Future<?> submit = executorService.submit(taskC);
        Object o = submit.get();
        System.out.println(Thread.currentThread().getName());
    }

    @Test
    public void test5() throws Exception {
        DemoTaskB task = new DemoTaskB();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        executorService.submit(futureTask);
        while (!futureTask.isDone()) {
            Thread.sleep(1000);
            System.out.println("waiting...");
        }
        Integer result = futureTask.get();
        System.out.println(result);
    }

    // submit.get()会造成主线程阻塞
    @Test
    public void test6() throws Exception {
        Integer result = null;
        DemoTaskB taskB = new DemoTaskB();
        Future<Integer> submit = executorService.submit(taskB);
        for (int i = 1; i <= 5; i++) {
            Thread.sleep(i * 1000);
            System.out.println("wait " + i * 1000);
            result = submit.get();
            if (result != null) {
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + "---" + result);
    }

    // ExecutorCompletionService解决submit.get()会造成主线程阻塞的问题
    @Test
    public void test7() throws Exception {
        Integer result = null;
        DemoTaskB taskB = new DemoTaskB();
        ExecutorCompletionService<Integer> service = new ExecutorCompletionService<>(executorService);
        Future<Integer> submit = service.submit(taskB);
        for (int i = 1; i <= 5; i++) {
            Thread.sleep(i * 1000);
            System.out.println("wait " + i * 1000);
            boolean done = submit.isDone();
            if (!done) {
                continue;
            } else {
                result = submit.get();
            }
        }
        System.out.println(Thread.currentThread().getName() + "---" + result);
    }

    // ExecutorCompletionService解决submit.get()会造成主线程阻塞的问题
    @Test
    public void test8() throws Exception {
        DemoTaskB taskB = new DemoTaskB();
        CompletionService<Integer> service = new ExecutorCompletionService<>(executorService);
        service.submit(taskB);
        Integer result = null;
        while (result == null) {
            Thread.sleep(2000);
            // take()也会阻塞当前线程
            result = service.take().get();
            if (result == null) {
                System.out.println("wait...");
            }
        }
        System.out.println(Thread.currentThread().getName() + "---" + result);
    }
}
