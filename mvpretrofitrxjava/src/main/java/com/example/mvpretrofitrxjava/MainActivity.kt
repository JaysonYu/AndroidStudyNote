package com.example.mvpretrofitrxjava

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity(), IBookView {

    var text = "MainActivity"
    private lateinit var mPresenter: BookPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = BookPresenter(this)
        initView("点击")
        btn_request.text = "请求"
    }

    private fun initView(text: String) {
        this.text = text
        btn_request.setOnClickListener { mPresenter.requestData("择天记", null, 0, 1) }
    }

    private fun MainActivity.showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun queryFail(error: String) {
        showToast(error)
    }

    override fun querySuccess(book: Book) {
        showToast("请求成功！！")
        tv_text.text = book.toString()
    }

}
