package com.example.hamster.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CaseHumidity implements Serializable {
    private Integer chId;

    private Integer hamsterId;

    private BigDecimal ch;

    private Date chTime;

    private Date insertDateTime;

    private Date updateDateTime;

    private String insertUser;

    private String updateUser;

    private static final long serialVersionUID = 1L;

    public Integer getChId() {
        return chId;
    }

    public void setChId(Integer chId) {
        this.chId = chId;
    }

    public Integer getHamsterId() {
        return hamsterId;
    }

    public void setHamsterId(Integer hamsterId) {
        this.hamsterId = hamsterId;
    }

    public BigDecimal getCh() {
        return ch;
    }

    public void setCh(BigDecimal ch) {
        this.ch = ch;
    }

    public Date getChTime() {
        return chTime;
    }

    public void setChTime(Date chTime) {
        this.chTime = chTime;
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