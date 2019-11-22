package com.jere.android_serializable_parcelable_learning;

import java.io.Serializable;

/**
 * @author jere
 */
public class User implements Serializable {
    private String name;
    private String age;
    private String hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

}
