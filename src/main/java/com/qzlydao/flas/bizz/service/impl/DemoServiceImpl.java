package com.qzlydao.flas.bizz.service.impl;

import com.qzlydao.flas.bizz.service.DemoService;
import com.qzlydao.flas.commom.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;

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
}
