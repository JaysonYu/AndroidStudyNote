package com.example.mvpretrofitrxjava

/**
 * @author jianxin on 2018/7/17.
 */
interface IBookView {

    fun querySuccess(book: Book)
    fun queryFail(error: String)
}