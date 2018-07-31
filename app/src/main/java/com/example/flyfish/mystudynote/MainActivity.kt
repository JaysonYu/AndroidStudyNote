package com.example.flyfish.mystudynote

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author jianxin on 2018/7/27.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_snap_helper.setOnClickListener{startActivity(Intent(this,SnapHelperAct::class.java))}
    }
}