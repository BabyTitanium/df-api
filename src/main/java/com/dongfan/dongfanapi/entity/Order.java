package com.dongfan.dongfanapi.entity;

import java.util.Date;

public class Order {
    private Integer id;

    private String entityType;

    private Integer entityId;

    private String entityName;

    private Integer status;

    private Integer userId;

    private Integer type;

    private String payTool;

    private Integer orderPrice;

    private Integer payPrice;

    private Date createAt;

    private String orderNo;

    private String payNo;

    private String invateCode;

    public Order(Integer id, String entityType, Integer entityId, String entityName, Integer status, Integer userId, Integer type, String payTool, Integer orderPrice, Integer payPrice, Date createAt, String orderNo, String payNo, String invateCode) {
        this.id = id;
        this.entityType = entityType;
        this.entityId = entityId;
        this.entityName = entityName;
        this.status = status;
        this.userId = userId;
        this.type = type;
        this.payTool = payTool;
        this.orderPrice = orderPrice;
        this.payPrice = payPrice;
        this.createAt = createAt;
        this.orderNo = orderNo;
        this.payNo = payNo;
        this.invateCode = invateCode;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType == null ? null : entityType.trim();
    }

    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName == null ? null : entityName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPayTool() {
        return payTool;
    }

    public void setPayTool(String payTool) {
        this.payTool = payTool == null ? null : payTool.trim();
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(Integer payPrice) {
        this.payPrice = payPrice;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    public String getInvateCode() {
        return invateCode;
    }

    public void setInvateCode(String invateCode) {
        this.invateCode = invateCode == null ? null : invateCode.trim();
    }
}