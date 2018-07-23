package com.example.mvpretrofitrxjava

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author jianxin on 2018/7/17.
 */
interface ApiServise {

    @GET("book/search")
    fun getSearchBooks(@Query("q") name: String,
                       @Query("tag") tag: String?,
                       @Query("start") start: Int,
                       @Query("count") count: Int): Observable<Book>
}
