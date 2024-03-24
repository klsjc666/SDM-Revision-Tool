package org.SDM.common.mybatis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String id;

    protected String inputUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    protected Date inputTime;

    protected String updateUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    protected Date updateTime;

    protected Integer version;
    /**
     * 是否启用：是（Y）；否（N）
     */
    private String enabled;
    /**
     * 删除标志 1删除 0正常（使用）
     */
    private BigDecimal delMark;

    public void setWhoForInsert(String userId){
        this.inputUser = userId;
        this.inputTime = new Date();
        this.updateUser = userId;
        this.updateTime = this.inputTime;
        this.setId(UUID.randomUUID().toString().replace("-",""));
    }

    public void setWhoForUpdate(String userId){
        this.updateUser = userId;
        this.updateTime = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInputUser() {
        return inputUser;
    }

    public void setInputUser(String inputUser) {
        this.inputUser = inputUser;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public BigDecimal getDelMark() {
        return delMark;
    }

    public void setDelMark(BigDecimal delMark) {
        this.delMark = delMark;
    }
}
