package com.hc.libs_base.Entity.registerentity.save;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by Administrator on 2018/4/13.
 * mark:hc
 * 个人中心完善信息
 */
@RealmClass
public class Center implements RealmModel {


    /**
     * 性别
     * 生日/出生日期
     * 现在联系地址
     */
    private String gender;
    private String birthday;
    private String address;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Center{" +
                "gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
