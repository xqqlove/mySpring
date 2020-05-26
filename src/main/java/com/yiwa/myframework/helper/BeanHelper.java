package com.yiwa.myframework.helper;

import com.yiwa.myframework.utils.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean助手类
 */
public class BeanHelper {
    /**
     * BEAN_MAP相当于一个bean容器, 拥有项目所有bean的实例
     */
    private static final Map<Class<?>,Object> BEAN_MAP=new HashMap<>();
    static {
        //获取所有bean
        Set<Class<?>> beanClassSet=ClassHelper.getBeanClassSet();
        //将bean实例化，并放入到bean容器中
        for (Class<?> beanClass:beanClassSet){
            Object obj= ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass,obj);
        }
    }
    /**
     * 获取Bean容器
     */
    public static Map<Class<?> ,Object> getBeanMap(){return BEAN_MAP;}
    /**
     * 获取bean实例
     */
    public static <T> T getBean(Class<T> cls){
        if (!BEAN_MAP.containsKey(cls)){
            throw new RuntimeException("can not get bean by class: "+cls);
        }
        return (T) BEAN_MAP.get(cls);
    }
    /**
     * 设置Bean实例
     */
    public static void setBean(Class<?> cls,Object obj){
        BEAN_MAP.put(cls,obj);
    }
}
