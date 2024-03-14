package com.aks.pojo;

import java.io.Serializable;

/**
 * @Auther: zms
 * @Date: 2024/2/26 - 02 - 26 - 9:26
 * @Description: com.aks.pojo
 * @version: 1.0
 */
public class User implements Serializable {
    private Integer cno;
    private String cname;
    private String room;

    @Override
    public String toString() {
        return "User{" +
                "cno=" + cno +
                ", cname='" + cname + '\'' +
                ", room='" + room + '\'' +
                '}';
    }



    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
