package com.presentation.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class UserInfo {
    @Id(autoincrement = true)
    private long id;

    @Index(unique = true)
    private int userId;

    private String userName;

    private String token;

    @Generated(hash = 1268223723)
    public UserInfo(long id, int userId, String userName, String token) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.token = token;
    }

    @Generated(hash = 1279772520)
    public UserInfo() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
