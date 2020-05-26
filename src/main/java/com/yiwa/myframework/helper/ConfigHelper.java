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
    private static final  Properties CONFIG_PROPS= PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取JDBC驱动
     * @return
     */
    private static String getJdbcDriver(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取JDBC_URL
     * @return
     */
    public static String  getJdbcUrl(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }

    /**
     * 获取JDBC用户名
     * @return
     */
    public static String getIdbcUserName(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取JDBC密码
     * @return
     */
    public static String getJdbcPassword(){return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);}

    /**
     * 获取应用基础包名
     * @return
     */
    public static String getAppBasePackage(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取应用JSP路径
     * @return
     */
    public static String getAppJspPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH,"WEB_INF/View");
    }
    /**
     * 获取静态资源路径
     */
    public static String getAppAssetPath(){
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_ASSET_PATH,"/asset");
    }

    /**
     * 根据属性名获取int类型属性值
     * @param key
     * @return
     */
    public static int getInt(String key){
        return PropsUtil.getInt(CONFIG_PROPS,key);
    }
    /**
     * 根据属性名获取boolean类型属性值
     */
    public static boolean getBoolean(String key){
        return PropsUtil.getBoolean(CONFIG_PROPS,key);
    }

}
