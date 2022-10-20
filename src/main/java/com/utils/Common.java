package com.utils;

import com.alibaba.fastjson.JSONPath;

public class Common {
    /**
     * 从json字符串中获取数据
     * @param str 源字符串
     * @param exp JsonPath表达式
     * @return 返回匹配到的字符串
     */
    public static String GetStringFromJson(String str,String exp){
        return JSONPath.read(str,exp).toString();
    }
}
