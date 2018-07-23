package com.example.togglebutton;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author jianxin on 2018/6/28.
 */
public class CakeView extends View {

    private int defultSize = 400;
    private Paint mPaint;
    private RectF mRectF;
    private int diameter; //直径
    private ArrayList<CakeBean> mList;
    private int mWSize;
    private int mHSize;
    private RectF mIrectF;
    private int mTextY;

    public CakeView(Context context) {
        this(context,null);
    }

    public CakeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }



    public CakeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    private void init() {
        mRectF = new RectF();
        mPaint = new Paint();
        mList = new ArrayList<>();
        //设置抗锯齿
        mPaint.setAntiAlias(true);
        //设置防抖动
        mPaint.setDither(true);
        setData();
    }

    private void setData() {
        mList.add(new CakeBean("科比", 5.90f, 90.00f, Color.parseColor("#ff0000")));
        mList.add(new CakeBean("詹姆斯", 45.50f, 90.00f, Color.parseColor("#00ff00")));
        mList.add(new CakeBean("韦德", 15.60f, 90.00f, Color.parseColor("#0000ff")));
        mList.add(new CakeBean("姚明", 29.10f, 90.00f, Color.parseColor("#3e3e3e")));
    }

    class CakeBean {
        CakeBean(String name,float value,float degree,int color) {
            this.name = name;
            this.value = value;
            this.degree = degree;
            this.mColor = color;
        }
        public String name;//名字
        public float value;//值
        public float degree;//旋转过的角度
        public int mColor;//圆弧颜色
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        diameter = Math.min(mWSize, mHSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWSize = getMySize(defultSize, widthMeasureSpec);
        mHSize = getMySize(defultSize, heightMeasureSpec);
        setMeasuredDimension(mWSize, mHSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //设置圆形的绘制范围
        mRectF.set(0,0,diameter,diameter);
        canvas.translate((mWSize - diameter)/8,(mHSize - diameter)/2);
        float startAngle = 0;
        mTextY = 0;
        for (int i = 0; i < mList.size(); i++) {
            canvas.drawArc(mRectF,startAngle,mList.get(i).degree,true,mPaint);
            startAngle += mList.get(i).degree;
            mPaint.setColor(mList.get(i).mColor);

            drawRecAndText(canvas,mList.get(i));
        }

    }

    private void drawRecAndText(Canvas canvas, CakeBean cakeBean) {
        mIrectF = new RectF();
        int right = diameter + 40 + 80;
        int bottom = mTextY + 40;
        mIrectF.set(diameter+40,mTextY,right,bottom);
        mPaint.setColor(cakeBean.mColor);
        mPaint.setTextSize(30);
        canvas.drawRect(mIrectF,mPaint);
        canvas.drawText(cakeBean.name + new DecimalFormat(".00").format(cakeBean.value) + "%",right+10,mTextY+30,mPaint);
        mTextY += 40;
    }

    public int getMySize(int defultSize, int measureSpec) {
        int mSize = defultSize;
        int size = MeasureSpec.getSize(measureSpec);
        int mode = MeasureSpec.getMode(measureSpec);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
                break;
            case MeasureSpec.AT_MOST:
                mSize = defultSize;
                break;
            case MeasureSpec.EXACTLY:
                mSize = size;
                break;
        }
        return mSize;
    }
}
