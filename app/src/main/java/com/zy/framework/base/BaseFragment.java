package com.zy.framework.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private View root;
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root=inflater.inflate(setContentView(),container,false);
        mUnbinder= ButterKnife.bind(this,root);
        initContentView();
        initData();
        return root;
    }

    public View getRoot() {
        return root;
    }

    protected abstract int setContentView();
    protected abstract void initContentView();
    protected abstract void initData();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder!=null) {
            mUnbinder.unbind();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected <T extends View> T findViewById(int id){
        return root.findViewById(id);
    }
}
