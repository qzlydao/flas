package com.qzlydao.flas.commom.redis;

public interface RedisService {

    /**
     * 指定缓存的有效时间
     *
     * @param key     键
     * @param timeout 时间（秒）
     * @return
     */
    boolean expire(String key, long timeout);

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return 值
     */
    Object get(String key);

    /**
     * 设置普通缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    boolean set(String key, Object value);

}
