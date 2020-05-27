package com.yiwa.myframework.proxy;

import com.yiwa.myframework.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

//public class TransactionProxy implements Proxy {
//    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionProxy.class);
//    @Override
//    public Object doProxy(ProxyChain proxyChain) throws Throwable {
//        Object result;
//        Method method = proxyChain.getTargetMethod();
//        //加了@Transactional注解的方法要做事务处理
//        if (method.isAnnotationPresent(Transactional.class)) {
//            try {
//                DatabaseHelper.beginTransaction();
//                LOGGER.debug("begin transaction");
//                result = proxyChain.doProxyChain();
//                DatabaseHelper.commitTransaction();
//                LOGGER.debug("commit transaction");
//            } catch (Exception e) {
//                DatabaseHelper.rollbackTransaction();
//                LOGGER.debug("rollback transaction");
//                throw e;
//            }
//        } else {
//            result = proxyChain.doProxyChain();
//        }
//        return result;
//    }
//}
