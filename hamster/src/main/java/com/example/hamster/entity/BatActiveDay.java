package com.example.hamster.entity;

import java.io.Serializable;
import java.util.Date;

public class BatActiveDay implements Serializable {
    private Short hamsterId;

    private Date activeDate;

    private Integer totalLap;

    private Date insertDateTime;

    private String insertUser;

    private static final long serialVersionUID = 1L;

    public Short getHamsterId() {
        return hamsterId;
    }

    public void setHamsterId(Short hamsterId) {
        this.hamsterId = hamsterId;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }

    public Integer getTotalLap() {
        return totalLap;
    }

    public void setTotalLap(Integer totalLap) {
        this.totalLap = totalLap;
    }

    public Date getInsertDateTime() {
        return insertDateTime;
    }

    public void setInsertDateTime(Date insertDateTime) {
        this.insertDateTime = insertDateTime;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public void setInsertUser(String insertUser) {
        this.insertUser = insertUser == null ? null : insertUser.trim();
    }
}