package com.hc.libs_base;

import android.app.Application;
import android.content.Context;
import com.alibaba.android.arouter.launcher.ARouter;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2018/4/9.
 */
public class MyApplication extends Application {

    public static MyApplication myApplication;
    public static Context context;

    public static Context getIntent() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        context = getApplicationContext();
        //Realm
        intiRealm(myApplication);
        //Arouter
        initARouter(myApplication);
    }

    /**
     * 数据库
     *
     * @param myApplication
     */
    public void intiRealm(MyApplication myApplication) {
        Realm.init(myApplication);
        //使用默认配置
        //Realm realm=Realm.getDefaultInstance();
        //RealmConfiguration 来配置Realm实现持久化
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("myrealm.realm")//文件名
                .schemaVersion(1)//版本号
                .deleteRealmIfMigrationNeeded()//声明版本冲突时自动删除原数据库。
                .build();
        Realm.getInstance(configuration);
    }

    /**
     * 路由
     *
     * @param myApplication
     */
    public void initARouter(MyApplication myApplication) {
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(myApplication);
    }
}
