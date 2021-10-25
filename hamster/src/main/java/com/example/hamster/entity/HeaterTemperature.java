package com.example.hamster.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class HeaterTemperature implements Serializable {
    private Integer htId;

    private Integer hamsterId;

    private BigDecimal ht;

    private Date htTime;

    private Date insertDateTime;

    private Date updateDateTime;

    private String insertUser;

    private String updateUser;

    private static final long serialVersionUID = 1L;

    public Integer getHtId() {
        return htId;
    }

    public void setHtId(Integer htId) {
        this.htId = htId;
    }

    public Integer getHamsterId() {
        return hamsterId;
    }

    public void setHamsterId(Integer hamsterId) {
        this.hamsterId = hamsterId;
    }

    public BigDecimal getHt() {
        return ht;
    }

    public void setHt(BigDecimal ht) {
        this.ht = ht;
    }

    public Date getHtTime() {
        return htTime;
    }

    public void setHtTime(Date htTime) {
        this.htTime = htTime;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public Date getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser == null ? null : insertUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }
}