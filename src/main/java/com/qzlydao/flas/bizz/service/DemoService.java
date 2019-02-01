package com.qzlydao.flas.bizz.service;

import java.util.Map;

public interface DemoService {

    /**
     * 多线程使用
     *
     * @param input
     * @return
     */
    Map<String, Object> threadDemo(String input);
}
