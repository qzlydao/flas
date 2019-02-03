package com.qzlydao.flas.bizz.service.impl;

import com.qzlydao.flas.bizz.service.DemoService;
import com.qzlydao.flas.bizz.task.FindMaxTask;
import com.qzlydao.flas.commom.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liuqiang
 * Date: 2019-02-01 18:12
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired ExecutorService executorService;
    @Autowired RedisService    redisService;

    @Override
    public Map<String, Object> threadDemo(Map<String, Object> input) {
        final Map<String, Object> resp = new HashMap<>();
        Set<Map.Entry<String, Object>> entries = input.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            Object value = entry.getValue();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "---" + key);
                    resp.put(key, value);
                }
            });

        }
        return resp;
    }

    @Override
    public Object threadDemoWithResult(String param) throws ExecutionException, InterruptedException {
        int[] data1 = new int[10];
        int[] data2 = new int[10];
        for (int i = 0, j = 0; i < 10 && j < 10; i++, j++) {
            int random = new SecureRandom(new byte[1024]).nextInt(10);
            int random2 = new SecureRandom(new byte[1024]).nextInt(10);
            data1[i] = random;
            data2[j] = random2;
        }
        for (int i : data1) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i : data2) {
            System.out.print(i + " ");
        }
        FindMaxTask task = new FindMaxTask(data1);
        FindMaxTask task2 = new FindMaxTask(data2);
        Future<Integer> future = executorService.submit(task);
        Future<Integer> future2 = executorService.submit(task2);

        Map<String, Object> result = new HashMap<>();
        result.put("result1", future.get());
        result.put("result2", future2.get());
        return result;
    }
}
