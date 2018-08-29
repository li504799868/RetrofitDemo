package com.lzp.retrofitdemo;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * Created by li.zhipeng on 2018/8/29.
 *
 *  把得到网络请求结果String，转换成ResponseWrapper
 */
public class ResponseWrapperCallAdapterFactory extends CallAdapter.Factory  {

    @Override
    public CallAdapter<String, ResponseWrapper> get(@NonNull final Type returnType, @NonNull Annotation[] annotations, @NonNull Retrofit retrofit) {
        return new CallAdapter<String, ResponseWrapper>() {

            @Override
            public Type responseType() {
                return returnType;
            }

            @Override
            public ResponseWrapper adapt(@NonNull Call<String> call) {
                try {
                    return new ResponseWrapper(call.execute().body());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return new ResponseWrapper("error");
            }
        };
    }
}
