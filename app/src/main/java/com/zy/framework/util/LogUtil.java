package com.zy.framework.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;

import com.zy.zywanandroid.app.MyApplication;

import java.util.Locale;

/**
 * Created by Zhaoyue on 2018/9/27 0027.
 * 使用只带有msg参数的log方法会自动获取线程名等信息，会有性能损失
 *  所以有性能需求的时候请使用
 */
public class LogUtil {
    public static final String TAG_DEFAULT = "ZYwanandroid";
    private static final String TAG_CONTENT_PRINT = "%s:%s.%s:%d";

    public static final int V = 1;
    public static final int D = 2;
    public static final int I = 3;
    public static final int W = 4;
    public static final int E = 5;

    private static int sInternalLevel = D;

    public static void initLevel(int level) {
        sInternalLevel = level;
    }

    public static void defaultInit(Context context){
        initLevel(isApkInDebug(context)?V:I);
    }

    public static boolean isApkInDebug(Context context) {
        try { ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static int getLogLevel() {
        return sInternalLevel;
    }

    /*
      instance implements=========================================================
     */
    public static void v(String msg){
        log(V,TAG_DEFAULT, getContent(getCurrentStackTraceElement()) + "--->" + msg,null);
    }

    public static void v(String tag, String msg) {
        log(V, tag, msg, null);
    }

    public static void v(String tag, Throwable tr, String msg) {
        log(V, tag, msg, tr);
    }

    public static void v(String tag, Throwable tr, String msg, Object... args) {
        if (V >= sInternalLevel)
            log(V, tag, concatMsg(msg, args), null);
    }

    public static void d(String msg){
        log(D,TAG_DEFAULT, getContent(getCurrentStackTraceElement()) + "--->" + msg,null);
    }

    public static void d(String tag, String msg) {
        log(D, tag, msg, null);
    }

    public static void d(String tag, Throwable tr, String msg) {
        log(D, tag, msg, tr);
    }

    public static void d(String tag, Throwable tr, String msg, Object... args) {
        if (D >= sInternalLevel)
            log(D, tag, concatMsg(msg, args), null);
    }

    public static void i(String msg){
        log(I,TAG_DEFAULT, getContent(getCurrentStackTraceElement()) + "--->" + msg,null);
    }

    public static void i(String tag, String msg) {
        log(I, tag, msg, null);
    }

    public static void i(String tag, Throwable tr, String msg) {
        log(I, tag, msg, tr);
    }

    public static void i(String tag, Throwable tr, String msg, Object... args) {
        if (I >= sInternalLevel)
            log(I, tag, concatMsg(msg, args), null);
    }

    public static void w(String msg){
        log(W,TAG_DEFAULT, getContent(getCurrentStackTraceElement()) + "--->" + msg,null);
    }

    public static void w(String tag, String msg) {
        log(W, tag, msg, null);
    }

    public static void w(String tag, Throwable tr, String msg) {
        log(W, tag, msg, tr);
    }

    public static void w(String tag, Throwable tr, String msg, Object... args) {
        if (W >= sInternalLevel)
            log(W, tag, concatMsg(msg, args), null);
    }

    public static void e(String msg){
        log(E,TAG_DEFAULT, getContent(getCurrentStackTraceElement()) + "--->" + msg,null);
    }

    public static void e(String tag, String msg) {
        log(E, tag, msg, null);
    }

    public static void e(String tag, Throwable tr, String msg) {
        log(E, tag, msg, tr);
    }

    public static void e(String tag, Throwable tr, String msg, Object... args) {
        if (E >= sInternalLevel)
            log(E, tag, concatMsg(msg, args), null);
    }
     /*
    instance implements=========================================================
     */


    private static String concatMsg(String msg, Object... args) {
        if (null != args && args.length > 0) {
            return String.format(msg, args);
        } else {
            return msg;
        }
    }

    /**
     * 打印的log信息 类名.方法名:行数--->msg
     */
    private static String getContent(StackTraceElement trace) {
        String t = "\""+Thread.currentThread().getName()+"\"";
        if (trace == null){
            return t;
        }
        return String.format(Locale.CHINA, TAG_CONTENT_PRINT, t,trace.getClassName(), trace.getMethodName(),
                trace.getLineNumber());
    }

    /**
     * 获得当前的 堆栈
     */
    private static StackTraceElement getCurrentStackTraceElement() {
        try {
            return Thread.currentThread().getStackTrace()[4];
        } catch (Exception e) {
            return null;
        }
    }

    private static int log(int level, String tag, String msg, Throwable tr) {
        if (level < sInternalLevel)
            return 0;

        if (!TAG_DEFAULT.equals(tag)){
            tag = TAG_DEFAULT + "-" +tag;
        }

        if (tr == null) {
            switch (level) {
                case V:
                    return Log.v(tag, msg);
                case D:
                    return Log.d(tag, msg);
                case I:
                    return Log.i(tag, msg);
                case W:
                    return Log.w(tag, msg);
                case E:
                    return Log.e(tag, msg);
            }
        } else {
            switch (level) {
                case V:
                    return Log.v(tag, msg, tr);
                case D:
                    return Log.d(tag, msg, tr);
                case I:
                    return Log.i(tag, msg, tr);
                case W:
                    return Log.w(tag, msg, tr);
                case E:
                    return Log.e(tag, msg, tr);
            }
        }

        throw new IllegalArgumentException("no such level:" + level);
    }
}
