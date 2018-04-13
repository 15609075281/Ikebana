package com.hc.libs_base.Entity.registerentity;

import com.hc.libs_base.Entity.registerentity.save.Center;
import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by Administrator on 2018/4/13.
 * mark:hc
 */
@RealmClass
public class RegisterEntity implements RealmModel {


    /**
     * 用户名
     * 验证吗
     * 密码
     * 确认密码
     * 个人中心资料完善
     */
    private String username;
    private String code;
    private String password;
    private String pass;

    private Center centers;

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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Center getCenters() {
        return centers;
    }

    public void setCenters(Center centers) {
        this.centers = centers;
    }

    @Override
    public String toString() {
        return "RegisterEntity{" +
                "username='" + username + '\'' +
                ", code='" + code + '\'' +
                ", password='" + password + '\'' +
                ", pass='" + pass + '\'' +
                ", centers=" + centers +
                '}';
    }


}
