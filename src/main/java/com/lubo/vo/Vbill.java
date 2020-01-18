package com.lubo.vo;

import com.lubo.pojo.Provider;

import java.sql.Timestamp;

public class Vbill {
    private Long id;
    private String billCode;
    private String productName;
    private Double totalPrice;
    private Timestamp creationDate;
    private Long isPayment;
    private String productUnit;
    private Double productCount;
    private Provider provider;

    public Vbill() {
    }

    public Vbill(Long id, String billCode, String productName, Double totalPrice, Timestamp creationDate, Long isPayment, String productUnit, Double productCount, Provider provider) {
        this.id = id;
        this.billCode = billCode;
        this.productName = productName;
        this.totalPrice = totalPrice;
        this.creationDate = creationDate;
        this.isPayment = isPayment;
        this.productUnit = productUnit;
        this.productCount = productCount;
        this.provider = provider;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
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

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Long getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(Long isPayment) {
        this.isPayment = isPayment;
    }

    public Double getProductCount() {
        return productCount;
    }

    public void setProductCount(Double productCount) {
        this.productCount = productCount;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }


    @Override
    public String toString() {
        return "Vbill{" +
                "id=" + id +
                ", billCode='" + billCode + '\'' +
                ", productName='" + productName + '\'' +
                ", totalPrice=" + totalPrice +
                ", creationDate=" + creationDate +
                ", isPayment=" + isPayment +
                ", productUnit='" + productUnit + '\'' +
                ", productCount=" + productCount +
                ", provider=" + provider +
                '}';
    }
}
