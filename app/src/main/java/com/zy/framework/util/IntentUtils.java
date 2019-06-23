package com.zy.framework.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by ZhaoYue on 2019/6/24.
 */
public class IntentUtils {

    public static <T extends Activity> void startActivity(Context context, Class<T> tClass){
        Intent intent = new Intent(context,tClass);
        context.startActivity(intent);
    }
}
