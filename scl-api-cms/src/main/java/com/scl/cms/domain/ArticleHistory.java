package com.scl.cms.domain;

import java.io.Serializable;
import java.util.Date;

public class ArticleHistory implements Serializable {
    private String id;

    private String articleId;

    private Integer operateFlag;

    private String operateBy;

    private Date operateTime;

    private String articleContentOld;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Integer getOperateFlag() {
        return operateFlag;
    }

    public void setOperateFlag(Integer operateFlag) {
        this.operateFlag = operateFlag;
    }

    public String getOperateBy() {
        return operateBy;
    }

    public void setOperateBy(String operateBy) {
        this.operateBy = operateBy;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getArticleContentOld() {
        return articleContentOld;
    }

    public void setArticleContentOld(String articleContentOld) {
        this.articleContentOld = articleContentOld;
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
        ArticleHistory other = (ArticleHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(other.getArticleId()))
            && (this.getOperateFlag() == null ? other.getOperateFlag() == null : this.getOperateFlag().equals(other.getOperateFlag()))
            && (this.getOperateBy() == null ? other.getOperateBy() == null : this.getOperateBy().equals(other.getOperateBy()))
            && (this.getOperateTime() == null ? other.getOperateTime() == null : this.getOperateTime().equals(other.getOperateTime()))
            && (this.getArticleContentOld() == null ? other.getArticleContentOld() == null : this.getArticleContentOld().equals(other.getArticleContentOld()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
        result = prime * result + ((getOperateFlag() == null) ? 0 : getOperateFlag().hashCode());
        result = prime * result + ((getOperateBy() == null) ? 0 : getOperateBy().hashCode());
        result = prime * result + ((getOperateTime() == null) ? 0 : getOperateTime().hashCode());
        result = prime * result + ((getArticleContentOld() == null) ? 0 : getArticleContentOld().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", articleId=").append(articleId);
        sb.append(", operateFlag=").append(operateFlag);
        sb.append(", operateBy=").append(operateBy);
        sb.append(", operateTime=").append(operateTime);
        sb.append(", articleContentOld=").append(articleContentOld);
        sb.append("]");
        return sb.toString();
    }
}