package com.lzp.retrofitdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import okhttp3.OkHttpClient
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var api: TestApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRetrofit()

        Thread {
            val result = api.postData("www.baidu.com", "111").response
            runOnUiThread {
                val textView = findViewById<TextView>(R.id.textView)
                textView.text = result
            }

        }.start()

    }

    private fun initRetrofit() {
        val retrofit = Retrofit.Builder()
                // 必填项
                .baseUrl("http://www.baidu.com")
                .client(OkHttpClient())
                // 对得到的结果进行转换，常用的有加密解密，json转换等等
                .addConverterFactory(StringConvertFactory())
                // 对返回的结果进行封装，常用的有之间转化成Rxjava对象
                // 这里我们简单的进行包装
                .addCallAdapterFactory(ResponseWrapperCallAdapterFactory())
                .build()

        api = retrofit.create(TestApi::class.java)
    }
}
