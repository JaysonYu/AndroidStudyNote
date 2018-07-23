package com.example.designpatterns.singleton;

/**
 * @author jianxin on 2018/3/19.
 * 单例模式
 */

/**
 * 饿汉式
 */
public class Singleton {

    private static Singleton mSingleton = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return mSingleton;
    }
}
