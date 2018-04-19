package com.hc.libs_base.database.realm;

import android.util.Log;

import com.hc.libs_base.Entity.cityentity.CityEntity;
import com.hc.libs_base.Entity.loginentity.LoginEntity;
import com.hc.libs_base.Entity.registerentity.RegisterEntity;
import com.hc.libs_base.Entity.registerentity.save.Center;
import com.hc.libs_base.database.realm.manager.RealmManager;
import io.realm.*;

import java.io.*;

/**
 * Created by Administrator on 2018/4/10.
 * mark:hc
 */
public class RealmSql {

    public Realm realm;
    public RealmAsyncTask asyncTask;

    public RealmSql() {
        getRealm(RealmManager.getPersistentRealm());
    }

    public Realm getRealm(RealmConfiguration realmConfiguration) {
        if (realm == null) {
            synchronized (RealmSql.class) {
                if (realm == null) {
                    realm = Realm.getInstance(realmConfiguration);
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
     * -----------------------------------------增------------------------------------------
     */

    /**
     * beginTransaction 和 commitTransaction
     *
     * @param object
     * @param <E>
     */
    public <E extends RealmModel> void saveObject(E object) {
        realm.beginTransaction();
        realm.copyToRealm(object);
        realm.commitTransaction();

    }
    /**
     * @param object
     * @param <E>
     */
    public <E extends RealmModel> void saveList(RealmList<E> object) {
        realm.beginTransaction();
        realm.copyToRealm(object);
        realm.commitTransaction();
    }

    /**
     * executeTransactionAsync
     *
     * @param object
     */
    public <T extends RealmModel> T saveExecuteTransactionAsync(final Class<T> object) {

        asyncTask = realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
//                E registerEntities ;//=
                T e = realm.createObject(object);
                e.toString();
//                registerEntities.setUsername("黄渤中22");
//                registerEntities.setPassword("123456");
//                Log.e("", "");
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("onSuccess", "onSuccess");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                Log.e("onError", "onError");
            }
        });
        return null;
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
     *
     * @param object
     */
    public void saveCopyToRealm(final Object object) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm((Iterable<RealmModel>) object);
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
                Center center = realm.createObject(Center.class);
                center.setGender("男");
                center.setBirthday("09-11");
                center.setAddress("中路河道蟹");
                registerEntity.setCenters(center);
            }
        });

    }

    /**
     * realm将json字符串转化为对象
     */
    public <E extends RealmModel> void stringJson(final Class<E> tClass, final String json) {

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.createObjectFromJson(tClass, json);
            }
        });
    }

    /**
     * InputStream装换
     */
    public void stringInputStreamJson() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    InputStream is = new FileInputStream(new File("乘法"));
                    realm.createAllFromJson(CityEntity.class, is);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    /**
     * -----------------------------------------删------------------------------------------
     */
    //deleteFromRealm
    public <T extends RealmModel> RealmResults<T> deleteFromRealm(Class<T> tClass) {
        final RealmResults<T> realmResults = realm.where(tClass).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
//               registerEntities.get(0).deleteFromRealm();
                realmResults.deleteFromRealm(0);
            }
        });
        return realmResults;
    }

    /**
     * -----------------------------------------改------------------------------------------
     */
    //更新数据
    public <T extends RealmModel> void upDate(final Class<T> tClass) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                T registerEntity = realm.where(tClass).findFirst();
//
//                registerEntity.setUsername("黄哈哈哈");
            }
        });
    }
    /**
     * -----------------------------------------查------------------------------------------
     */

    /**
     * 查询所有
     */
    public <E extends RealmModel> RealmResults<E> findAll(Class<E> class1) {
        RealmResults<E> es = realm.where(class1).findAll();
        return es;
    }

    /**
     * findAllAsync——异步查询
     * 值得注意的是，这里并不会马上查到数据，是有一定延时的。
     * 也就是说，你马上使用 userList 的时候，里面是没有数据的。
     * 可以注册 RealmChangeListener 监听器，或者使用 isLoaded() 方法，判断是否查询完成
     * if (result.isLoaded()) {
     * // 完成查询
     * }
     */
    public <T extends RealmModel> RealmResults<T> findAllAsync(Class<T> tClass) {
        RealmResults<T> registerEntities = realm.where(tClass).findAllAsync();
        if (registerEntities.isLoaded()) {
            // 完成查询
            return registerEntities;
        } else {
            return null;
        }
    }

    /**
     * findFirst ——查询第一条数据
     */
    public <T extends RealmModel> T findFirst(Class<T> tClass) {
        T first = realm.where(tClass).findFirst();
        return first;
    }

    /**
     * equalTo ——根据条件查询
     */
    public <T extends RealmModel> RealmResults<T> equalTo(Class<T> tClass, String key, String value) {
        RealmResults<T> realmResults = realm.where(tClass)
                .equalTo(key, value)
                .findAll();
        //根据子类获得父类的数据
//        RealmResults<RegisterEntity> registerEntity1=realm.where(RegisterEntity.class)
//                .equalTo("userNameEntities.username","黄渤中三号")
//                .findAll();
        return realmResults;
    }

    /**
     * equalTo ——多条件查询
     */
    public <T extends RealmModel> RealmResults<T> equalToAdd(Class<T> tClass, String key1, String child_key2, String value1, String value2) {
        RealmResults<T> realmResults = realm.where(tClass)
                .equalTo(key1, value1)
                .equalTo(child_key2, value2)
                .findAll();
        return realmResults;
    }

    /**
     * RealmQuery 以及 or 的使用
     *
     * @param tClass
     * @param key1        父类的key
     * @param child_key   子类的key
     * @param value
     * @param child_value
     * @param <E>
     * @return
     */
    public <E extends RealmModel> RealmResults<E> RealmQuery(Class<E> tClass, String key1, String child_key, String value, String child_value) {
        RealmResults<E> registerEntities = realm.where(tClass)
                .equalTo(key1, value)
                .or().equalTo(child_key, child_value)
                .findAll();
        return registerEntities;
    }

    /**
     * 正向排序
     *
     * @param tClass
     * @param key    一般根据id来排序
     * @param <T>
     * @return
     */
    public <T extends RealmModel> RealmResults<T> sortRealm(Class<T> tClass, String key) {
        RealmResults<T> realmResults = realm.where(tClass).findAll();
        realmResults = realmResults.sort(key);//正序排序
        return realmResults;
    }

    /**
     * 逆向排序
     *
     * @param tClass
     * @param key
     * @param <T>
     */
    public <T extends RealmModel> RealmResults<T> sortRealmDescending(Class<T> tClass, String key) {
        RealmResults<T> realmResults = realm.where(tClass).findAll();
        realmResults = realmResults.sort(key, Sort.DESCENDING);
        return realmResults;
    }


}
