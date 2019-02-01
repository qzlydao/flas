package com.qzlydao.flas.bizz.service.impl;

import com.qzlydao.flas.bizz.service.DemoService;
import com.qzlydao.flas.commom.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
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
    public Map<String, Object> threadDemo(String input) {
        Map<String, Object> resp = null;
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                redisService.set(input, input);
            }
        });
        Object value = redisService.get(input);
        if (value != null) {
            resp = new HashMap<>();
            resp.put(input, input);
        }
        return resp;
    }
}
