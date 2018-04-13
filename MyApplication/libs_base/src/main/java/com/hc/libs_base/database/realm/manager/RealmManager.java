package com.hc.libs_base.database.realm.manager;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Administrator on 2018/4/13.
 */
public class RealmManager {

    private RealmManager(){};
    /**
     * 创建持久化的数据库
     */
    public static void getPersistentRealm() {
        // RealmConfiguration 来配置Realm实现持久化
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("myrealm.realm")//文件名
                .schemaVersion(1)//版本号
                .build();
        Realm.getInstance(configuration);
    }

    /**
     * 创建非持久化的数据库
     */
    public void getNoPersistentRealm() {
        //RealmConfiguration 来配置Realm实现非持久化
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myrealm.realm")//保存在内存中
                .inMemory()//声明数据库只在内存中持久化。
                .deleteRealmIfMigrationNeeded()//声明版本冲突时自动删除原数据库。
                .build();
        Realm.getInstance(config);
    }

}
