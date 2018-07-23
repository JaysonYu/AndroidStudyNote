package com.example.mvpretrofitrxjava

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * @author jianxin on 2018/7/17.
 */
class BookPresenter constructor(iBookView: IBookView) {

    private var iBookView = iBookView
    private var manager: DataManager = DataManager()
    private lateinit var mBook: Book

    fun requestData(name: String, tag: String?, start: Int, count:Int) {
        manager.getServiseBook(name,tag,start,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Book> {

                    override fun onSubscribe(d: Disposable) {

                    }

                    override fun onComplete() {
                        iBookView.querySuccess(mBook)
                    }

                    override fun onNext(book: Book) {
                        mBook = book
                    }

                    override fun onError(e: Throwable) {
                        iBookView.queryFail("请求失败！！")
                    }
                })
    }
}