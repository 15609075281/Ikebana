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

    public RealmSql() {
        RealmManager.getPersistentRealm();
        getRealm();
    }

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
     * -----------------------------------------增------------------------------------------
     */

    /**
     * executeTransactionAsync
     *
     * @param object
     */
    public void saveExecuteTransactionAsync(Object object) {
        asyncTask = realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RegisterEntity registerEntities = realm.createObject(RegisterEntity.class);
                registerEntities.setUsername("黄渤中22");
                registerEntities.setPassword("123456");
                Log.e("", "");
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
                Center center = realm.createObject(Center.class);
                center.setGender("男");
                center.setBirthday("09-11");
                center.setAddress("中路河道蟹");
                registerEntity.setCenters(center);
            }
        });

    }

    /**
     * beginTransaction 和 commitTransaction
     */
    public void saveBeginTransaction() {
        realm.beginTransaction();//开启事物
        RegisterEntity registerEntity = realm.createObject(RegisterEntity.class);
        registerEntity.setUsername("黄渤中4号");
        registerEntity.setUsername("123456");
        realm.commitTransaction();//提交事物
        Log.e("", "");
    }

    /**
     * realm将json字符串转化为对象
     */
    public void stringJson() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.createObjectFromJson(CityEntity.class, "{city:\"成都\",id:1}");
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
    public void deleteFromRealm() {
        final RealmResults<RegisterEntity> registerEntities = realm.where(RegisterEntity.class).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
//               registerEntities.get(0).deleteFromRealm();
                registerEntities.deleteFromRealm(0);
            }
        });

    }

    /**
     * -----------------------------------------改------------------------------------------
     */
    //更新数据
    public void upDate() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RegisterEntity registerEntity = realm.where(RegisterEntity.class).findFirst();
                registerEntity.setUsername("黄哈哈哈");
            }
        });
    }
    /**
     * -----------------------------------------查------------------------------------------
     */

    /**
     * 查询所有
     */
    public RealmResults<RegisterEntity> findAll() {
        RealmResults<RegisterEntity> registerEntities = realm.where(RegisterEntity.class).findAll();
        return registerEntities;
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
    public void findAllAsync() {
        RealmResults<RegisterEntity> registerEntities = realm.where(RegisterEntity.class).findAllAsync();
        if (registerEntities.isLoaded()) {
            // 完成查询
        }
    }

    /**
     * findFirst ——查询第一条数据
     */
    public void findFirst() {
        RegisterEntity registerEntities = realm.where(RegisterEntity.class).findFirst();
    }

    /**
     * equalTo ——根据条件查询
     */
    public void equalTo() {
        RealmResults<RegisterEntity> registerEntity = realm.where(RegisterEntity.class)
                .equalTo("username", "黄渤中")
                .findAll();
        //根据子类获得父类的数据
//        RealmResults<RegisterEntity> registerEntity1=realm.where(RegisterEntity.class)
//                .equalTo("userNameEntities.username","黄渤中三号")
//                .findAll();

    }

    /**
     * equalTo ——多条件查询
     */
    public void equalToAdd() {
        RealmResults<RegisterEntity> registerEntity = realm.where(RegisterEntity.class)
                .equalTo("username", "黄渤中")
                .equalTo("userNameEntities.username", "黄渤中三号")
                .findAll();
    }

    /**
     * RealmQuery 以及 or 的使用
     */
    public void RealmQuery() {
        RealmResults<RegisterEntity> registerEntities = realm.where(RegisterEntity.class)
                .equalTo("username", "黄渤中")
                .or().equalTo("", "黄渤中")
                .findAll();
    }

    /**
     * 排序
     */
    public void sort() {
        RealmResults<RegisterEntity> registerEntities = realm.where(RegisterEntity.class).findAll();
        registerEntities = registerEntities.sort("id");//正序排序
        registerEntities = registerEntities.sort("id", Sort.DESCENDING);//逆向排序
    }


}
