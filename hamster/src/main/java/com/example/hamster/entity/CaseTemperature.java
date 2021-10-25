package com.example.hamster.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CaseTemperature implements Serializable {
    private Integer ctId;

    private Integer hamsterId;

    private BigDecimal ct;

    private Date ctTime;

    private Date insertDateTime;

    private Date updateDateTime;

    private String insertUser;

    private String updateUser;

    private static final long serialVersionUID = 1L;

    public Integer getCtId() {
        return ctId;
    }

    public void setCtId(Integer ctId) {
        this.ctId = ctId;
    }

    public Integer getHamsterId() {
        return hamsterId;
    }

    public void setHamsterId(Integer hamsterId) {
        this.hamsterId = hamsterId;
    }

    public BigDecimal getCt() {
        return ct;
    }

    public void setCt(BigDecimal ct) {
        this.ct = ct;
    }

    public Date getCtTime() {
        return ctTime;
    }

    public void setCtTime(Date ctTime) {
        this.ctTime = ctTime;
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