package com.lubo.vo;

import com.lubo.pojo.Role;

import java.sql.Date;

public class Vuser {
    private Long id;
    private String userCode;
    private String userName;
    private String phone;
    private String address;
    private Integer gender;
    private Date birthday;
    private Integer age;
    private Long userRole;
    private Role role;

    public Vuser() {
    }

    public Long getUserRole() {
        return userRole;
    }

    public void setUserRole(Long userRole) {
        this.userRole = userRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Role getRole() {
        return role;
    }

    public Integer getAge() {
        Date d=new Date(System.currentTimeMillis());
        return d.getYear()-getBirthday().getYear();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Vuser{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", age=" + age +
                ", userRole=" + userRole +
                ", role=" + role +
                '}';
    }
}
