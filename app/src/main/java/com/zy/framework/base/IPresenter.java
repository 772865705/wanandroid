package com.zy.framework.base;

import android.os.Bundle;

public interface IPresenter {
    void onCreate(Bundle saveInstance);
    void onStart();
    void onStop();
    void onDestroy();
    void onResume();
    void onPause();
}
