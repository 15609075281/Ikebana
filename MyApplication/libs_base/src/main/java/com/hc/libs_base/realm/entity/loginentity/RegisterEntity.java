package com.hc.libs_base.realm.entity.loginentity;

import com.hc.libs_base.realm.entity.UserNameEntity;
import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by Administrator on 2018/4/10.
 * mark:hc
 */
@RealmClass
public class RegisterEntity implements RealmModel {


    private int id;
    private String username;
    private String password;

    public UserNameEntity userNameEntities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserNameEntity getUserNameEntities() {
        return userNameEntities;
    }

    public void setUserNameEntities(UserNameEntity userNameEntities) {
        this.userNameEntities = userNameEntities;
    }

    @Override
    public String toString() {
        return "RegisterEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userNameEntities=" + userNameEntities +
                '}';
    }


}
