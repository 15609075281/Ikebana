package com.hc.libs_base;

import android.app.Application;
import android.content.Context;
import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by Administrator on 2018/4/9.
 */
public class MyApplication extends Application {

    public static MyApplication myApplication;

    public static Context getIntent() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        initARouter(myApplication);
    }

    public void initARouter(MyApplication myApplication) {

//        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
//        }
        ARouter.init(myApplication);
    }
}
