package com.yiwa.myframework;

import com.yiwa.myframework.annotation.Controller;
import com.yiwa.myframework.helper.BeanHelper;
import com.yiwa.myframework.helper.ClassHelper;
import com.yiwa.myframework.helper.ControllerHelper;
import com.yiwa.myframework.helper.IocHelper;
import com.yiwa.myframework.utils.ClassUtil;

/**
 * 加载相应的Helper 类
 */
public final class HelperLoader {
    /**
     * 加载这五个类，目的是为了执行类里面的静态代码块
     */
    public static void init(){
        Class<?>[] classList={
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class,
        };
        for (Class<?> cls:classList){
            ClassUtil.loadClass(cls.getName());
        }
    }
}
