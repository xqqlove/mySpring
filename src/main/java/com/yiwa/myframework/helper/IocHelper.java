package com.yiwa.myframework.helper;

import com.yiwa.myframework.annotation.Autowired;
import com.yiwa.myframework.utils.ReflectionUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

//依赖注入助手类
public final class IocHelper {
    /**
     * 遍历bean容器所有bean属性，为所有带@Autowired注解注入实例
     */
    static {
        //遍历bean容器中多有bean
        Map<Class<?>,Object> beanMap=BeanHelper.getBeanMap();
        if (MapUtils.isNotEmpty(beanMap)){
            for (Map.Entry<Class<?>,Object> beanEntry:beanMap.entrySet()){
                //bean的class类
                Class<?> beanClass=beanEntry.getKey();
                //bean的实例
                Object beanInstance=beanEntry.getValue();
                //反射获取属性
                Field[] beanFields=beanClass.getDeclaredFields();
                //遍历bean属性
                if (ArrayUtils.isNotEmpty(beanFields)){
                    for (Field beanFIeld:beanFields){
                        //判断属性是否带有autowired注解
                        if (beanFIeld.isAnnotationPresent(Autowired.class)){
                            //属性类型
                            Class<?> beanFieldClass=beanFIeld.getType();
                            //如果beanFiledClass是接口，就获取接口对应的实现类
                            beanFieldClass=findImplementClass(beanFieldClass);
                            //获取class类对应的实例
                            Object beanFieldInstance=beanMap.get(beanFieldClass);
                            if (beanFieldInstance!=null){
                                ReflectionUtil.setField(beanInstance,beanFIeld,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 获取接口对应的实现类
     */
    public static Class<?> findImplementClass(Class<?> interfaceClass){
        Class<?> implementClass=interfaceClass;
        //接口对应的多有实现类
        Set<Class<?>> classSetBySuper=ClassHelper.getClassSetBySupper(interfaceClass);
        if (CollectionUtils.isNotEmpty(classSetBySuper)){
            //获取第一个实现类
            implementClass=classSetBySuper.iterator().next();
        }
        return implementClass;
    }
}
