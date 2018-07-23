package com.example.mvpretrofitrxjava

/**
 * @author jianxin on 2018/7/17.
 */
class DataManager {

    private var mServise: ApiServise = RetrofitHelper.getServise()

    fun getServiseBook(name: String, tag: String?, start: Int, count: Int)
            = mServise.getSearchBooks(name, tag, start, count)

}