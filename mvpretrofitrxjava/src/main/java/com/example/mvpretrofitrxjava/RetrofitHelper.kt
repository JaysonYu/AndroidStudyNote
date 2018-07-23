package com.example.mvpretrofitrxjava

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author jianxin on 2018/7/17.
 */
object RetrofitHelper {

    private lateinit var mRetrofit: Retrofit
    private val mClient: OkHttpClient = OkHttpClient()
    private val mFactory: GsonConverterFactory = GsonConverterFactory.create()

    init {
        resetApp()
    }

    private fun resetApp() {
        mRetrofit = Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .client(mClient)
                .addConverterFactory(mFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    /**
     * 获取ApiServise接口实例化
     */
    fun getServise() = mRetrofit.create(ApiServise::class.java)!!
}