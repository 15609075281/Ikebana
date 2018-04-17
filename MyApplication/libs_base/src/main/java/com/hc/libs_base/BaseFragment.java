package com.hc.libs_base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2018/4/13.
 */
public abstract class BaseFragment extends Fragment {

    public Context context;
    public View view;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }


    /**
     * 绑定view 不能执行耗时操作
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(intiView(), container, false);
    }

    public abstract int intiView();

    public abstract void findView();

    /**
     * ui交互操作
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        view=getView();
        findView();
    }

}
