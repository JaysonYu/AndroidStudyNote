package com.example.togglebutton

import android.content.Context
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.View

/**
 * @author jianxin on 2018/7/18.
 */
class SideBar : View {

    lateinit var mPaint: Paint

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : this(context, attributeSet,0)
    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr) {
        init()
    }

    private fun init() {
        mPaint = Paint()
//        mPaint
    }


}