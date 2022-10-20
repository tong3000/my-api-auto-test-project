package com.utils;

import java.util.ResourceBundle;

public class ResourceLoad {
    private static final ResourceBundle resourceBundle;

    //代码块：加载资源文件，设置环境数据
    static {
        ResourceBundle env = ResourceBundle.getBundle("config");
        String env1 = env.getString("env");

        if ("config_a1".equals(env1)) {
            resourceBundle = ResourceBundle.getBundle("config_a1");
        } else {
            resourceBundle = ResourceBundle.getBundle("config_a2");
        }
    }

    public static String getKey(String key) {
        return resourceBundle.getString(key);
    }
}
