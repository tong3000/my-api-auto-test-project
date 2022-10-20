package com.base;

import io.restassured.response.Response;
import java.util.Map;
import static io.restassured.RestAssured.given;

//定义Request基本方法
public class Base {

    /**
     * 不带头信息发送get请求
     * @param url  接口url
     * @return 返回Response类型的接口返回
     */
    public Response HttpGet(String url){
        Response response =given().when().get(url);
        return response;
    }

    /**
     * 带header发送get请求
     * @param url  接口url
     * @param headers  头信息， Map<String,String>
     * @return 返回Response类型的接口返回
     */
    public Response HttpGet(String url, Map<String,String> headers){
        Response response =given().headers(headers).when().get(url);
        return response;
    }


    /**
     * 不带header发送post请求
     * @param url 接口url
     * @param body body入参
     * @return 返回Response类型的接口返回
     */
    public Response HttpPost(String url,String body){
        Response response =given().body(body).when().post(url);
        return response;
    }

    /**
     * 带header发送post请求
     * @param url 接口url
     * @param headers 头信息， Map<String,String>
     * @param body body入参
     * @return 返回Response类型的接口返回
     */
    public Response HttpPost(String url, Map<String,String> headers,String body){
        Response response =given().headers(headers).body(body).when().post(url);
        return response;
    }

    /**
     * 从接口返回的Response中获取整个接口返回值
     * @param res  接口返回的整个response
     * @return String类型的body
     */
    public String GetBodyFromResponse(Response res){
        return res.getBody().asString();
    }

    /**
     * 从接口返回的Response中获取接口返回状态码
     * @param res 接口返回的整个response
     * @return int类型的状态码
     */
    public int GetCodeFromResponse(Response res){
        return res.getStatusCode();
    }

}
