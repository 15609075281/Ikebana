package com.hc.libs_base.realm.entity.cityentity;

import io.realm.RealmModel;
import io.realm.annotations.RealmClass;

/**
 * Created by Administrator on 2018/4/10.
 */
@RealmClass
public class CityEntity implements RealmModel {

    private int id;
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "id=" + id +
                ", city='" + city + '\'' +
                '}';
    }
}
