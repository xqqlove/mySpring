package com.yiwa.myframework.helper;


import com.yiwa.myframework.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 切面编辑助手类
 */
public final class AopHelper {
    private static final Logger logger= LoggerFactory.getLogger(AopHelper.class);

//    static {
//        //切面类-目标类集合的映射
//        Map<Class<?> , Set<Class<?>>> aspectMap=c
//    }
//    private static Map<Class<?> ,Set<Class<?>>> createAspectMap() throws Exception{
//        Map<Class<?>,Set<Class<?>>> aspectMap=new HashMap<>();
//
//    }


    /**
     * 获取事务切面类-目标类集合的映射
     */
    private static void addTransactionProxy(Map<Class<?>,Set<Class<?>>> aspectMap){
        Set<Class<?>> serviceClassSet=ClassHelper.getClassSetByAnnotation(Service.class);
//        aspectMap.put(Tran)
    }
}
