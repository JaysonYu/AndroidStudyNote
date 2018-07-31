package com.example.flyfish.mystudynote

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.imag_item.view.*

/**
 * @author jianxin on 2018/7/27.
 */
class SnapHelperAdapter : RecyclerView.Adapter<SnapHelperAdapter.ScapHelperVH>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ScapHelperVH {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.imag_item, p0, false)
        return ScapHelperVH(view)
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(p0: ScapHelperVH, p1: Int) {
        p0.bind(p1)
    }

    class ScapHelperVH(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        fun bind(p1: Int) {
            itemView.iv_img.setBackgroundColor(Color.parseColor("#ff00" + p1 + "0"))
        }

    }
}