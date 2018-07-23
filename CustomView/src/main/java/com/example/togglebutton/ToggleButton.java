package com.example.togglebutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author jianxin on 2018/4/21.
 */

public class ToggleButton extends View {

    private Bitmap mBackBitmap;
    private Bitmap mButtonBitmap;
    private float  mLeft;
    private int    mBackwidth;
    private int    mBackHeight;
    private boolean isOpen;

    public ToggleButton(Context context) {
        this(context, null);
    }

    public ToggleButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        @SuppressLint("Recycle")
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ToggleButton);
        isOpen = typedArray.getBoolean(R.styleable.ToggleButton_isOpen, false);
        Log.d("isOpen", isOpen + "");
        typedArray.recycle();
        init();
    }

    public ToggleButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ToggleButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this(context, attrs, defStyleAttr);
    }

    private void init() {
        //将图片转成bitmap对象存储在内存
        mBackBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.switch_background);
        mButtonBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.slide_button);
        mBackwidth = mBackBitmap.getWidth();
        mBackHeight = mBackBitmap.getHeight();
        if (isOpen) {
            open();
        } else {
            close();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                mLeft = event.getX() - mButtonBitmap.getWidth() / 2;
                if (mLeft < 0) {
                    mLeft = 0;
                } else if (mLeft > mBackwidth - mButtonBitmap.getWidth()) {
                    mLeft = mBackwidth - mButtonBitmap.getWidth();
                }
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                float currentX = event.getX();
                if (currentX > mBackwidth / 2) {
                    open();
                } else {
                    close();
                }

                break;
        }
        return true;
    }

    private void close() {
        isOpen = false;
        mLeft = 0;
        invalidate();
    }

    private void open() {
        isOpen = true;
        mLeft = mBackwidth - mButtonBitmap.getWidth();
        Log.d("mLeft", "mBackwidth" + mBackwidth + "mButtonBitmap.getWidth()" + mButtonBitmap.getWidth() + mLeft + "=====");
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMesure = MeasureSpec.makeMeasureSpec(mBackwidth, MeasureSpec.EXACTLY);
        int heightMesure = MeasureSpec.makeMeasureSpec(mBackHeight, MeasureSpec.EXACTLY);
        setMeasuredDimension(widthMesure, heightMesure);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBackBitmap, 0, 0, null);
        canvas.drawBitmap(mButtonBitmap, mLeft, 0, null);
    }
}
