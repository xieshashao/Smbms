package com.bdqn.pojo;

import java.util.Date;

/**
 * Created by java on 2017/7/14.
 */
public class Bill {
    private   int  id;
    private  String  billCode;     //订单编码
    private  String  productName;  //商品名称
    private  String  productDesc;  //商品描述
    private  String  productUnit;  //商品单位
    private  Float  productCount;  //商品数量
    private  Float totalPrice;    //商品总额
    private  int  isPayment;     //是否支付（1：表示未支付   2：表示已支付）
    private  int  providerId;    //供应商ID
    private  int  createdBy;     //创建者  userId
    private Date creationDate;   //创建时间
    private  int  modifyBy;      //更新者 userId
    private  Date modifyDate;    //更新时间
    private  String proName;

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    private Provider provider;  //植入Provider实体

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Float getProductCount() {
        return productCount;
    }

    public void setProductCount(Float productCount) {
        this.productCount = productCount;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(int isPayment) {
        this.isPayment = isPayment;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(int modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
