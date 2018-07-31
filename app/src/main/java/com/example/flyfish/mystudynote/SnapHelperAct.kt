package com.example.flyfish.mystudynote

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.PagerSnapHelper
import kotlinx.android.synthetic.main.activity_snap_helper.*

/**
 * @author jianxin on 2018/7/27.
 */
class SnapHelperAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snap_helper)

        initView()
    }

    private fun initView() {
        rv_snap_helper.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        //可滑动多页，居中显示
//        val snapHelper = LinearSnapHelper()
        //每次只能滑动一页，居中显示
        val pagerSnapHelper = PagerSnapHelper()
        val adapter = SnapHelperAdapter()
        rv_snap_helper.adapter = adapter
//        snapHelper.attachToRecyclerView(rv_snap_helper)
        pagerSnapHelper.attachToRecyclerView(rv_snap_helper)
    }
}