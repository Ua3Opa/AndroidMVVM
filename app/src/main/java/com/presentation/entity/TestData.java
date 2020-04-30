package com.presentation.entity;

public class TestData{

    /**
     * room_id : 1863767
     * room_src : https://rpic.douyucdn.cn/asrpic/200430/1863767_0949.png/dy1
     * room_name : 重播丨18点 RNG.M vs WE
     * owner_uid : 118232622
     * online : 2433600
     * hn : 2433600
     * nickname : 王者荣耀官方赛事
     * url : http://www.douyu.com/1863767
     */

    private int room_id;
    private String room_src;
    private String room_name;
    private String owner_uid;
    private int online;
    private int hn;
    private String nickname;
    private String url;

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRoom_src() {
        return room_src;
    }

    public void setRoom_src(String room_src) {
        this.room_src = room_src;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getOwner_uid() {
        return owner_uid;
    }

    public void setOwner_uid(String owner_uid) {
        this.owner_uid = owner_uid;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public int getHn() {
        return hn;
    }

    public void setHn(int hn) {
        this.hn = hn;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
