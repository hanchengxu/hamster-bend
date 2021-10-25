package com.example.hamster.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Hamster implements Serializable {
    private Integer hamsterId;

    private String hamsterName;

    private BigDecimal hamsterHeight;

    private BigDecimal hamsterWeight;

    private Date hamsterBirthday;

    private String hamsterKind;

    private Date startDate;

    private Date endDate;

    private Date insertDateTime;

    private Date updateDateTime;

    private String insertUser;

    private String updateUser;

    private static final long serialVersionUID = 1L;

    public Integer getHamsterId() {
        return hamsterId;
    }

    public void setHamsterId(Integer hamsterId) {
        this.hamsterId = hamsterId;
    }

    public String getHamsterName() {
        return hamsterName;
    }

    public void setHamsterName(String hamsterName) {
        this.hamsterName = hamsterName == null ? null : hamsterName.trim();
    }

    public BigDecimal getHamsterHeight() {
        return hamsterHeight;
    }

    public void setHamsterHeight(BigDecimal hamsterHeight) {
        this.hamsterHeight = hamsterHeight;
    }

    public BigDecimal getHamsterWeight() {
        return hamsterWeight;
    }

    public void setHamsterWeight(BigDecimal hamsterWeight) {
        this.hamsterWeight = hamsterWeight;
    }

    public Date getHamsterBirthday() {
        return hamsterBirthday;
    }

    public void setHamsterBirthday(Date hamsterBirthday) {
        this.hamsterBirthday = hamsterBirthday;
    }

    public String getHamsterKind() {
        return hamsterKind;
    }

    public void setHamsterKind(String hamsterKind) {
        this.hamsterKind = hamsterKind == null ? null : hamsterKind.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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