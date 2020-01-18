package com.lubo.pojo;


import java.sql.Date;
import java.sql.Timestamp;

public class User {

  private Long id;
  private String userCode;
  private String userName;
  private String userPassword;
  private Long gender;
  private java.sql.Date birthday;
  private String phone;
  private String address;
  private Long userRole;
  private Long createdBy;
  private java.sql.Timestamp creationDate;
  private Long modifyBy;
  private java.sql.Timestamp modifyDate;

  public User() {
  }

  public User(Long id, String userCode, String userName, String userPassword, Long gender, Date birthday, String phone, String address, Long userRole, Long createdBy, Timestamp creationDate, Long modifyBy, Timestamp modifyDate) {
    this.id = id;
    this.userCode = userCode;
    this.userName = userName;
    this.userPassword = userPassword;
    this.gender = gender;
    this.birthday = birthday;
    this.phone = phone;
    this.address = address;
    this.userRole = userRole;
    this.createdBy = createdBy;
    this.creationDate = creationDate;
    this.modifyBy = modifyBy;
    this.modifyDate = modifyDate;
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

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  public Long getGender() {
    return gender;
  }

  public void setGender(Long gender) {
    this.gender = gender;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getUserRole() {
    return userRole;
  }

  public void setUserRole(Long userRole) {
    this.userRole = userRole;
  }

  public Long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(Long createdBy) {
    this.createdBy = createdBy;
  }

  public Timestamp getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Timestamp creationDate) {
    this.creationDate = creationDate;
  }

  public Long getModifyBy() {
    return modifyBy;
  }

  public void setModifyBy(Long modifyBy) {
    this.modifyBy = modifyBy;
  }

  public Timestamp getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Timestamp modifyDate) {
    this.modifyDate = modifyDate;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", userCode='" + userCode + '\'' +
            ", userName='" + userName + '\'' +
            ", userPassword='" + userPassword + '\'' +
            ", gender=" + gender +
            ", birthday=" + birthday +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", userRole=" + userRole +
            ", createdBy=" + createdBy +
            ", creationDate=" + creationDate +
            ", modifyBy=" + modifyBy +
            ", modifyDate=" + modifyDate +
            '}';
  }
}
