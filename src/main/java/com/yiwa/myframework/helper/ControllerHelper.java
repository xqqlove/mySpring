package com.yiwa.myframework.helper;

import com.yiwa.myframework.annotation.RequestMapping;
import com.yiwa.myframework.bean.Handler;
import com.yiwa.myframework.bean.Request;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 控制器助手类
 * 相当于springmvc里的映射处理器，为请求URL设置对应的处理器
 */
public final class ControllerHelper {
    /**
     * REQUEST_MAP "请求-处理器"的映射
     */
    private static final Map<Request, Handler> REQUEST_MAP=new HashMap<>();

    static {
        //遍历所有的Controller类
        Set<Class<?>> controllerClassSet=ClassHelper.getControllerClassSet();
        if (CollectionUtils.isNotEmpty(controllerClassSet)){
            for (Class<?> controllerClass:controllerClassSet ){
                //反射获取所有的方法
                Method[] methods=controllerClass.getDeclaredMethods();
                //遍历方法
                if (ArrayUtils.isNotEmpty(methods)){
                    for (Method method:methods){
                        //判断是否带有requestMapping注解
                        if (method.isAnnotationPresent(RequestMapping.class)){
                            RequestMapping requestMapping=method.getAnnotation(RequestMapping.class);
                            //请求路径
                            String requestPath=requestMapping.value();
                            //请求方法
                            String requestMethod=requestMapping.method().name();
                            //封装请求和处理器
                            Request request=new Request(requestMethod,requestPath);
                            Handler handler=new Handler(controllerClass,method);
                            REQUEST_MAP.put(request,handler);
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取Handler
     */
    public static Handler getHandler(String requestMethod,String requestPath){
        Request request=new Request(requestMethod,requestPath);
        return REQUEST_MAP.get(request);
    }
}
