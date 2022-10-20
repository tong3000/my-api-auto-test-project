package com.apicase.UserModule;

import com.po.RequestApi;
import com.utils.Common;
import com.utils.ResourceLoad;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test01_user02_yonghudenglu {
    String user = ResourceLoad.getKey("testemail");
    String pwd = ResourceLoad.getKey("testpwd");
    RequestApi ra = new RequestApi();

    @BeforeTest
    public void setUp(){
        //登录
        ra.login(user,pwd);
    }

    @Test
    public void test02(){
        //获取用户信息
        String str = ra.user_getUserInfor();
        String infor = Common.GetStringFromJson(str,"$.data.name");
        Assert.assertEquals(infor,"测试");

    }

    @Test
    public void test03(){
        //获取用户信息
        String str = ra.user_getUserInfor();
        String infor = Common.GetStringFromJson(str,"$.data.name");
        Assert.assertEquals(infor,"测试");

        //增加地址
        String res =ra.user_addUserAdress("上海","0","大牛测试测试咨询部","123456","上海","童欢测试","浦东区");
        System.out.println(res);
        Assert.assertEquals(Common.GetStringFromJson(res,"$.data.phone"),"123456");

    }

    @AfterTest
    public void tearDown(){
        String str = ra.loginApi(user,pwd);
        System.out.println(str);

    }

}
