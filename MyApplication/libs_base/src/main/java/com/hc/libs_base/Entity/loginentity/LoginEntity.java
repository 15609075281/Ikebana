package com.hc.libs_base.Entity.loginentity;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;


/**
 * Created by Administrator on 2018/4/13.
 * mark:hc
 */
@RealmClass
public class LoginEntity implements RealmModel {

    /**
     * 用户名，手机号，邮箱
     * 验证吗
     * 密码
     * token
     */
    private String username;
    private String code;
    private String password;
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginEntity{" +
                "username='" + username + '\'' +
                ", code='" + code + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
