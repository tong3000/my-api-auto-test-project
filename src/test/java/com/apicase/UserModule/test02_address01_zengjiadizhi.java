package com.apicase.UserModule;

import com.po.RequestApi;
import com.utils.Common;
import com.utils.ResourceLoad;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test02_address01_zengjiadizhi {
    String user = ResourceLoad.getKey("testemail");
    String pwd = ResourceLoad.getKey("testpwd");
    RequestApi ra = new RequestApi();

    @BeforeTest
    public void setUp() {
        //登录
        ra.login(user, pwd);
    }

    @Test
    public void test02() {
        //增加用户地址
        String str = ra.user_addUserAdress("上海", "0", "测试咨询", "13216", "上海", "童欢测试", "浦东区");
        String infor = Common.GetStringFromJson(str, "$.data.phone");
        Assert.assertEquals(infor, "13216");

    }

    @AfterTest
    public void tearDown() {
        String str = ra.loginApi(user, pwd);

    }

}
