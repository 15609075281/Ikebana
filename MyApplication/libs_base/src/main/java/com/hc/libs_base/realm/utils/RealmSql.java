package com.hc.libs_base.realm.utils;

import com.hc.libs_base.realm.entity.LoginEntity;
import com.hc.libs_base.realm.entity.RegisterEntity;
import io.realm.Realm;
import io.realm.RealmAsyncTask;
import io.realm.RealmModel;

/**
 * Created by Administrator on 2018/4/10.
 */
public class RealmSql {

    public Realm realm;
    public RealmAsyncTask asyncTask;

    public Realm getRealm() {
        if (realm == null) {
            synchronized (RealmSql.class) {
                if (realm == null) {
                    realm = Realm.getDefaultInstance();
                }
            }
        }
        return realm;
    }

    /**
     * 如果当 Acitivity 或 Fragment 被销毁时，
     * 在 OnSuccess 或 OnError 中执行UI操作，将导致程序奔溃 。
     * 用 RealmAsyncTask .cancel();可以取消事务在 onStop 中调用，避免 crash。
     */
    public void stop() {
        if (asyncTask != null && !asyncTask.isCancelled()) {
            asyncTask.cancel();
        }
    }

    /**
     * 增
     *
     * @param object
     */
    public void save(Object object) {
        asyncTask = realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {

            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {

            }
        });
    }

    /**
     * 当Model中存在主键的时候，推荐使用 copyToRealmOrUpdate 方法插入数据。
     * 如果对象存在，就更新该对象；反之，它会创建一个新的对象。
     *
     * @param object
     */
    public void saveCopyToRealmOrUpdate(final Object object) {
        final LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUsername("黄渤中");
        loginEntity.setPassword("123456");
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate((Iterable<RealmModel>) loginEntity);
            }
        });
    }

    /**
     * 若该Model没有主键，使用 copyToRealm 方法，否则将抛出异常。
     * class LoginEntity {}
     * @param object
     */
    public void saveCopyToRealm(Object object) {
        final LoginEntity loginEntity = new LoginEntity();
        loginEntity.setUsername("黄渤中");
        loginEntity.setPassword("123456");
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm((Iterable<RealmModel>) loginEntity);
            }
        });
    }

    /**
     * RegisterEntity extends RealmObject{ }
     */
    public void saveCreateObject() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RegisterEntity registerEntity = realm.createObject(RegisterEntity.class);
                registerEntity.setUsername("黄渤中二号");
                registerEntity.setUsername("123456");
            }
        });

    }


}
