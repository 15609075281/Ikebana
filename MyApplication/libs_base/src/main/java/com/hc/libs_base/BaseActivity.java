package com.hc.libs_base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Administrator on 2018/4/10.
 * mark:hc
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //初始化界面
        setContentView(intiView());
        findView();
    }

    /**
     * 获取view
     */
    public abstract int intiView();

    /**
     * 初始化
     */
    public abstract void findView();

}
