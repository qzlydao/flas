package com.qzlydao.flas.bizz.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liuqiang
 * Date: 2019-01-26 17:46
 */
@RestController
public class DemoController {

    @PostMapping("/demo")
    public Object demo(@RequestBody Map<String, Object> param) {
        System.out.println("-------------");
        Map<Object, Object> map = new HashMap<>();
        map.put("aa", "11");
        map.put("bb", "22");
        // 
        return map;
    }

}
