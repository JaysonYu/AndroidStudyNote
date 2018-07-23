package com.example.flyfish.mystudynote;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HandlerActivity extends AppCompatActivity {

    private TextView mTextView;
    private Handler mHandler = new Handler();
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        mIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("aj","无言剧、、、、");
        mIntent.putExtras(bundle);
        mIntent.setAction("cn.scu.finch");
        mIntent.setPackage(getPackageName());
        mTextView = (TextView) findViewById(R.id.textview);

        //创建子线程,默认情况下Android不允许这样更新UI
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                    mTextView.setText("update thread");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mTextView.setText("update thread");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    protected void onStop() {
        this.startService(mIntent);
        super.onStop();
    }

    public void startServise(View view) {
//        Intent intent = new Intent("startIntentServise");
//        Bundle bundle = new Bundle();
//        bundle.putString("aj","无言剧、、、、");
//        intent.putExtras(bundle);
//        startService(intent);
    }
}
