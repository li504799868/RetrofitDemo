package com.lzp.retrofitdemo;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by li.zhipeng on 2018/8/29.
 */
public interface TestApi {


    /**
     * 模拟GET一个数据请求
     */
    @GET
    ResponseWrapper getData(@Url String url);

    /**
     * 模拟POST一个数据请求
     */
    @POST
    @FormUrlEncoded
    ResponseWrapper postData(@Url String url, @Field("wd") String key);
}
