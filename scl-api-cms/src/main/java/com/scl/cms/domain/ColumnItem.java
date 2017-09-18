package com.scl.cms.domain;

import java.io.Serializable;
import java.util.Date;

public class ColumnItem implements Serializable {
    private String id;

    private String columnId;

    private String language;

    private String name;

    private String url;

    private Integer whetherShow;

    private Integer whetherLinks;

    private Integer whetherStatic;

    private Integer hasAdvertising;

    private Integer sort;

    private String description;

    private String summary;

    private String remark;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getWhetherShow() {
        return whetherShow;
    }

    public void setWhetherShow(Integer whetherShow) {
        this.whetherShow = whetherShow;
    }

    public Integer getWhetherLinks() {
        return whetherLinks;
    }

    public void setWhetherLinks(Integer whetherLinks) {
        this.whetherLinks = whetherLinks;
    }

    public Integer getWhetherStatic() {
        return whetherStatic;
    }

    public void setWhetherStatic(Integer whetherStatic) {
        this.whetherStatic = whetherStatic;
    }

    public Integer getHasAdvertising() {
        return hasAdvertising;
    }

    public void setHasAdvertising(Integer hasAdvertising) {
        this.hasAdvertising = hasAdvertising;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ColumnItem other = (ColumnItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getColumnId() == null ? other.getColumnId() == null : this.getColumnId().equals(other.getColumnId()))
            && (this.getLanguage() == null ? other.getLanguage() == null : this.getLanguage().equals(other.getLanguage()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getWhetherShow() == null ? other.getWhetherShow() == null : this.getWhetherShow().equals(other.getWhetherShow()))
            && (this.getWhetherLinks() == null ? other.getWhetherLinks() == null : this.getWhetherLinks().equals(other.getWhetherLinks()))
            && (this.getWhetherStatic() == null ? other.getWhetherStatic() == null : this.getWhetherStatic().equals(other.getWhetherStatic()))
            && (this.getHasAdvertising() == null ? other.getHasAdvertising() == null : this.getHasAdvertising().equals(other.getHasAdvertising()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getSummary() == null ? other.getSummary() == null : this.getSummary().equals(other.getSummary()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getColumnId() == null) ? 0 : getColumnId().hashCode());
        result = prime * result + ((getLanguage() == null) ? 0 : getLanguage().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getWhetherShow() == null) ? 0 : getWhetherShow().hashCode());
        result = prime * result + ((getWhetherLinks() == null) ? 0 : getWhetherLinks().hashCode());
        result = prime * result + ((getWhetherStatic() == null) ? 0 : getWhetherStatic().hashCode());
        result = prime * result + ((getHasAdvertising() == null) ? 0 : getHasAdvertising().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getSummary() == null) ? 0 : getSummary().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", columnId=").append(columnId);
        sb.append(", language=").append(language);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", whetherShow=").append(whetherShow);
        sb.append(", whetherLinks=").append(whetherLinks);
        sb.append(", whetherStatic=").append(whetherStatic);
        sb.append(", hasAdvertising=").append(hasAdvertising);
        sb.append(", sort=").append(sort);
        sb.append(", description=").append(description);
        sb.append(", summary=").append(summary);
        sb.append(", remark=").append(remark);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}