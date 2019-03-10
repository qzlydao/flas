package com.qzlydao.flas.utils;

import com.qzlydao.flas.bizz.dto.ReqParam;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: liuqiang
 * Date: 2019-02-01 22:05
 */
public class BeanUtils {

    private BeanUtils() {
    }

    /**
     * 将javabean转成map
     *
     * @param object javabean
     * @return
     */
    public static Map<String, Object> convertBeanToMap(Object object) {
        Map<String, Object> map = null;
        if (null == object) {
            return null;
        }
        try {
            map = new HashMap<>();
            Class<?> aClass = object.getClass();
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor : propertyDescriptors) {
                if (!"class".equals(descriptor.getName())) {
                    String name = descriptor.getName();
                    Method readMethod = descriptor.getReadMethod();
                    Object invoke = readMethod.invoke(object, null);
                    map.put(name, invoke);
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
        ReqParam reqParam = new ReqParam();
        reqParam.setName("张三");
        reqParam.setAge(19);
        reqParam.setGender("M");

        Map<String, Object> map = convertBeanToMap(reqParam);
        System.out.println(map);

    }

}
