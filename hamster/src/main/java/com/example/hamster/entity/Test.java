package com.example.hamster.entity;

import java.io.Serializable;
import java.util.Date;

public class Test implements Serializable {
    private Integer activeId;

    private Short hamsterId;

    private Integer lapCount;

    private Date insertDateTime;

    private String insertUser;

    private static final long serialVersionUID = 1L;

    public Integer getActiveId() {
        return activeId;
    }

    public void setActiveId(Integer activeId) {
        this.activeId = activeId;
    }

    public Short getHamsterId() {
        return hamsterId;
    }

    public void setHamsterId(Short hamsterId) {
        this.hamsterId = hamsterId;
    }

    public Integer getLapCount() {
        return lapCount;
    }

    public void setLapCount(Integer lapCount) {
        this.lapCount = lapCount;
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