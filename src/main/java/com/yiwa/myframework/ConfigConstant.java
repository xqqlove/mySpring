package com.yiwa.myframework;

public interface ConfigConstant {
    //配置文件名称
    String CONFIG_FILE="yiwaApp.properties";
    //数据源
    String JDBC_DRIVER="yiwa.framework.jdbc.driver";
    String JDBC_URL="yiwa.framework.jdbc.url";
    String JDBC_USERNAME="yiwa.framework.jdbc.username";
    String JDBC_PASSWORD="yiwa.framework.jdbc.password";

    //java源码地址
    String APP_BASE_PACKAGE="yiwa.framework.app.base_package";
    //JSP页面路径
    String APP_JSP_PATH="yiwa.framework.app.jsp_path";
    //静态资源路径
    String APP_ASSET_PATH="yiwa.framework.app.asset_path";

}
