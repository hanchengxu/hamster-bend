package com.example.hamster.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AutoFeed implements Serializable {
    private Integer autoFeedId;

    private Short hamsterId;

    private Date feedTime;

    private BigDecimal feedAmount;

    private Date insertDateTime;

    private Date updateDateTime;

    private String insertUser;

    private String updateUser;

    private static final long serialVersionUID = 1L;

    public Integer getAutoFeedId() {
        return autoFeedId;
    }

    public void setAutoFeedId(Integer autoFeedId) {
        this.autoFeedId = autoFeedId;
    }

    public Short getHamsterId() {
        return hamsterId;
    }

    public void setHamsterId(Short hamsterId) {
        this.hamsterId = hamsterId;
    }

    public Date getFeedTime() {
        return feedTime;
    }

    public void setFeedTime(Date feedTime) {
        this.feedTime = feedTime;
    }

    public BigDecimal getFeedAmount() {
        return feedAmount;
    }

    public void setFeedAmount(BigDecimal feedAmount) {
        this.feedAmount = feedAmount;
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