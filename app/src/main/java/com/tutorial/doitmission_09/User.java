package com.tutorial.doitmission_09;

import java.util.Date;

public class User {
    private String name;
    private String birthday;
    private String phonnum;

    public User(String name, String birthday, String phonnum) {
        this.name = name;
        this.birthday = birthday;
        this.phonnum = phonnum;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhonnum() {
        return phonnum;
    }

    public void setPhonnum(String phonnum) {
        this.phonnum = phonnum;
    }
}
