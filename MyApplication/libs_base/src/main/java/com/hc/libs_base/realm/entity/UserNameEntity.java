package com.hc.libs_base.realm.entity;


import io.realm.RealmModel;
import io.realm.annotations.RealmClass;


/**
 * Created by Administrator on 2018/4/10.
 * mark:hc
 */
@RealmClass
public class UserNameEntity implements RealmModel {


    private int id;
    private String username;
    private String password;

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

    @Override
    public String toString() {
        return "UserNameEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
