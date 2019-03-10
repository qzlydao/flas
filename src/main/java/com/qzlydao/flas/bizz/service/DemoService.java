package com.qzlydao.flas.bizz.service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

public interface DemoService {

    /**
     * 多线程使用
     *
     * @param input
     * @return
     */
    Map<String, Object> threadDemo(Map<String, Object> input);

    /**
     * 使用多线程，并返回执行结果
     *
     * @param param
     */
    Object threadDemoWithResult(String param) throws ExecutionException, InterruptedException;
}
