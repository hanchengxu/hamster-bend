package com.example.hamster.entity;

import java.io.Serializable;
import java.util.Date;

public class Manager implements Serializable {
    private Integer managerId;

    private String managerName;

    private String managerAccount;

    private String managerPassword;

    private Short hamsterId;

    private Short familyId;

    private Date insertDateTime;

    private Date updateDateTime;

    private String insertUser;

    private String updateUser;

    private static final long serialVersionUID = 1L;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getManagerAccount() {
        return managerAccount;
    }

    public void setManagerAccount(String managerAccount) {
        this.managerAccount = managerAccount == null ? null : managerAccount.trim();
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public void setManagerPassword(String managerPassword) {
        this.managerPassword = managerPassword == null ? null : managerPassword.trim();
    }

    public Short getHamsterId() {
        return hamsterId;
    }

    public void setHamsterId(Short hamsterId) {
        this.hamsterId = hamsterId;
    }

    public Short getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Short familyId) {
        this.familyId = familyId;
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