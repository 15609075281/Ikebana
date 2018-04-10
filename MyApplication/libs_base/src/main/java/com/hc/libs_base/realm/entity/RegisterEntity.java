package com.hc.libs_base.realm.entity;

import io.realm.RealmObject;

/**
 * Created by Administrator on 2018/4/10.
 * mark:hc
 */
public class RegisterEntity extends RealmObject{


    public int id;

    public String username;

    public String password;


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
        return "LoginEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
