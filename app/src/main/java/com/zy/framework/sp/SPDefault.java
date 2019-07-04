package com.zy.framework.sp;

import android.content.Context;

import com.cocosw.favor.AllFavor;
import com.cocosw.favor.Default;

@AllFavor
public interface SPDefault {

    @Default("zhaoyue1")
    String name();
    void setName(String name);

}
