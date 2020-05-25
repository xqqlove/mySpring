package com.yiwa.myframework.helper;

import com.yiwa.myframework.ConfigConstant;
import com.yiwa.myframework.utils.PropsUtil;

import java.util.Properties;

/**
 * 属性文件助手类
 * 该类用于获取配置文件中的配置，其中JSP和静态资源设置了默认路径
 */
public final class ConfigHelper {
    /**
     * 加载配置文件的属性
     */
    private static final Properties CONFIG_PROPS= PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取JDBC驱动
     * @return
     */
    private static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }

}
