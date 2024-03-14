package com.aks.pojo;

/**
 * @Auther: zms
 * @Date: 2024/2/27 - 02 - 27 - 8:46
 * @Description: com.aks.pojo
 * @version: 1.0
 */
public class Player {
    private Integer id;

    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    private String cname;
    private String pwd;
    private String photoName;
    private String photoType;

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", photoName='" + photoName + '\'' +
                ", photoType='" + photoType + '\'' +
                '}';
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType;
    }


}
