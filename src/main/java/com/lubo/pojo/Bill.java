package com.lubo.pojo;


import java.io.Serializable;
import java.sql.Timestamp;

public class Bill implements Serializable {

  private Long id;
  private String billCode;
  private String productName;
  private String productDesc;
  private String productUnit;
  private Double productCount;
  private Double totalPrice;
  private Long isPayment;
  private Long createdBy;
  private java.sql.Timestamp creationDate;
  private Long modifyBy;
  private java.sql.Timestamp modifyDate;
  private Long providerId;

  public Bill() {
  }

  public Bill(Long id, String billCode, String productName, String productDesc, String productUnit, Double productCount, Double totalPrice, Long isPayment, Long createdBy, Timestamp creationDate, Long modifyBy, Timestamp modifyDate, Long providerId) {
    this.id = id;
    this.billCode = billCode;
    this.productName = productName;
    this.productDesc = productDesc;
    this.productUnit = productUnit;
    this.productCount = productCount;
    this.totalPrice = totalPrice;
    this.isPayment = isPayment;
    this.createdBy = createdBy;
    this.creationDate = creationDate;
    this.modifyBy = modifyBy;
    this.modifyDate = modifyDate;
    this.providerId = providerId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBillCode() {
    return billCode;
  }

  public void setBillCode(String billCode) {
    this.billCode = billCode;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getProductDesc() {
    return productDesc;
  }

  public void setProductDesc(String productDesc) {
    this.productDesc = productDesc;
  }

  public String getProductUnit() {
    return productUnit;
  }

  public void setProductUnit(String productUnit) {
    this.productUnit = productUnit;
  }

  public Double getProductCount() {
    return productCount;
  }

  public void setProductCount(Double productCount) {
    this.productCount = productCount;
  }

  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public Long getIsPayment() {
    return isPayment;
  }

  public void setIsPayment(Long isPayment) {
    this.isPayment = isPayment;
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

  public Long getProviderId() {
    return providerId;
  }

  public void setProviderId(Long providerId) {
    this.providerId = providerId;
  }

  @Override
  public String toString() {
    return "Bill{" +
            "id=" + id +
            ", billCode='" + billCode + '\'' +
            ", productName='" + productName + '\'' +
            ", productDesc='" + productDesc + '\'' +
            ", productUnit='" + productUnit + '\'' +
            ", productCount=" + productCount +
            ", totalPrice=" + totalPrice +
            ", isPayment=" + isPayment +
            ", createdBy=" + createdBy +
            ", creationDate=" + creationDate +
            ", modifyBy=" + modifyBy +
            ", modifyDate=" + modifyDate +
            ", providerId=" + providerId +
            '}';
  }
}
