package com.example.flyfish.mystudynote;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author jianxin on 2018/3/16.
 */

public class MyIntentServise extends IntentService {

    public MyIntentServise() {
        super("MyIntentServise");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        Log.d("onCreate", "服务开启");
        super.onCreate();
    }
}
