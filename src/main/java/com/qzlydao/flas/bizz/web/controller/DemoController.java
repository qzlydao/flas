package com.qzlydao.flas.bizz.web.controller;

import com.qzlydao.flas.bizz.dao.MatchDao;
import com.qzlydao.flas.commom.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liuqiang
 * Date: 2019-01-26 17:46
 */
@Slf4j
@RestController
public class DemoController {

    @PostMapping("/demo")
    public Object demo(@RequestBody Map<String, Object> param) {
        System.out.println("-------------");
        Map<Object, Object> map = new HashMap<>();
        map.put("aa", "11");
        map.put("bb", "22");
        return map;
    }

    @Autowired private MatchDao matchDao;

    @GetMapping("/getCount")
    public Map<String, Object> getCount() {
        int i = matchDao.queryCount();
        Map<String, Object> resp = new HashMap<>();
        resp.put("count", i);
        return resp;
    }

    @Autowired private RedisService redisService;

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

}
