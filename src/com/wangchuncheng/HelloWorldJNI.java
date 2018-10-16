package com.wangchuncheng;

/**
 * Created by Wangchuncheng on 2018/10/16 15:08
 */
public class HelloWorldJNI {
    static {
        System.loadLibrary("HelloWorld");
    }

    public HelloWorldJNI() {
    }

    public native void sayHello();
}
