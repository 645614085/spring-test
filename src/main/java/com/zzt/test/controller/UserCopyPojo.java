package com.zzt.test.controller;

/**
 * @Description com.zzt.test.controller
 * @auther zzt
 * @since 2019-08-15 15:58
 */
public class UserCopyPojo {

    private Integer id;

    private String name;

    private String pwd;

    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserCopyPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
