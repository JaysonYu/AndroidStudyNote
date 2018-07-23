package com.example.designpatterns.singleton;

/**
 * @author jianxin on 2018/3/20.
 */

public class Singleton3 {

    private static Singleton3 mSingleton = null;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if (null == mSingleton) {
            synchronized (Singleton3.class) {
                if (null == mSingleton) {
                    mSingleton = new Singleton3();
                }
            }
        }
        return mSingleton;
    }
}
