package com.lzp.retrofitdemo;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by li.zhipeng on 2018/8/29.
 *
 *      把得到的数据response转换成String
 */
public class StringConvertFactory extends Converter.Factory {

    @Override
    public Converter<ResponseBody, String> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new Converter<ResponseBody, String>() {
            @Override
            public String convert(@NonNull ResponseBody value) throws IOException {
                return value.string();
            }
        };
    }
}
