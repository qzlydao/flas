package com.qzlydao.flas.bizz.web.controller;

import com.qzlydao.flas.bizz.dao.MatchDao;
import com.qzlydao.flas.bizz.dto.ReqParam;
import com.qzlydao.flas.bizz.service.DemoService;
import com.qzlydao.flas.commom.redis.RedisService;
import com.qzlydao.flas.utils.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liuqiang
 * Date: 2019-01-26 17:46
 */
@Slf4j
@RestController
public class DemoController {

    @Autowired private DemoService  demoService;
    @Autowired private MatchDao     matchDao;
    @Autowired private RedisService redisService;

    @PostMapping("/demo")
    public Object demo(@RequestBody Map<String, Object> param) {
        System.out.println("-------------");
        Map<Object, Object> map = new HashMap<>();
        map.put("aa", "11");
        map.put("bb", "22");
        return map;
    }

    @GetMapping("/getCount")
    public Map<String, Object> getCount() {
        int i = matchDao.queryCount();
        Map<String, Object> resp = new HashMap<>();
        resp.put("count", i);
        return resp;
    }

    @PostMapping("/redisDemo")
    public Object redisDemo(@RequestBody Map<String, Object> reqParam) {
        Set<Map.Entry<String, Object>> entries = reqParam.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            String key = entry.getKey();
            Object value = entry.getValue();
            redisService.set(key, value);
        }
        return null;
    }

    @GetMapping("/threadDemo")
    public Object threadDemo(@ModelAttribute("reqParam") ReqParam reqParam) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> map = BeanUtils.convertBeanToMap(reqParam);
        Map<String, Object> result = demoService.threadDemo(map);
        return result;
    }

    @GetMapping("/threadDemo2")
    public Object threadDemo2(@RequestParam String param) throws ExecutionException, InterruptedException {
        Object result = demoService.threadDemoWithResult(param);
        return result;
    }

    // master

}
