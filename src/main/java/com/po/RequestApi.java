package com.po;

import com.base.Base;
import com.utils.Common;
import com.utils.ResourceLoad;
import io.restassured.response.Response;
import org.apache.http.client.methods.HttpGet;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;


public class RequestApi {
    Base base = new Base();
    String base_Url = ResourceLoad.getKey("base_url");
    String header_token = "";

    //登录接口
    public String loginApi(String mail,String pwd){
        String url =base_Url+"/api/user/v1/login";
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type","application/json");
        //String body = "{\\\"mail\\\":\\\"" +mail+"\\\",\\\"pwd\\\":\\\""+mail+"\\\"}";
        String body = "{\"mail\":\"" +mail+"\",\"pwd\":\""+pwd+"\"}";
        Response response = base.HttpPost(url,headers,body);
        Assert.assertEquals(base.GetCodeFromResponse(response),200);
        return base.GetBodyFromResponse(response);
    }

    //登录操作并获取赋值token
    public void login(String mail,String pwd){
        String body = loginApi(mail,pwd);
        header_token = Common.GetStringFromJson(body,"$.data");
    }

    //获取用户信息
    public String user_getUserInfor(){
        String url = base_Url+"/api/user/v1/detail";
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type","application/json");
        headers.put("token",header_token);
        String response = base.GetBodyFromResponse(base.HttpGet(url,headers));
        return response;
    }

    //添加用户地址
    public String user_addUserAdress(String city,String default_status,String detail_address,String phone,String province,String receive_name,String region){
        String url = base_Url+"/api/address/v1/add";
        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type","application/json");
        headers.put("token",header_token);
        String body ="{\"city\":\""+city+"\",\"default_status\":"+default_status+",\"detail_address\":\""+detail_address+"\",\"phone\":\""+phone+"\",\"province\":\""+province+"\",\"receive_name\":\""+receive_name+"\",\"region\":\""+region+"\"}";
        String response = base.GetBodyFromResponse(base.HttpPost(url,headers,body));
        return response;
    }

}
