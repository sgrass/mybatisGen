package com.iever.model;

import java.util.Date;

public class EveryDaySpecial {
    /**
     * 
     */
    private Integer id;

    /**
     * 专题标题
     */
    private String specialTitle;

    /**
     * 值得买专题标题
     */
    private String productTitle;

    /**
     * 专题第一篇文章封面
     */
    private String specialImgUrl;

    /**
     * 文章id 逗号分隔
     */
    private String articleIds;

    /**
     * 商品排行榜id
     */
    private Integer itemTopCateId;

    /**
     * 问题id
     */
    private Integer questionId;

    /**
     * 0正常状态、-1删除
     */
    private Integer status;

    /**
     * 每日专题时间(2015-06-05)
     */
    private Date specialTime;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecialTitle() {
        return specialTitle;
    }

    public void setSpecialTitle(String specialTitle) {
        this.specialTitle = specialTitle == null ? null : specialTitle.trim();
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle == null ? null : productTitle.trim();
    }

    public String getSpecialImgUrl() {
        return specialImgUrl;
    }

    public void setSpecialImgUrl(String specialImgUrl) {
        this.specialImgUrl = specialImgUrl == null ? null : specialImgUrl.trim();
    }

    public String getArticleIds() {
        return articleIds;
    }

    public void setArticleIds(String articleIds) {
        this.articleIds = articleIds == null ? null : articleIds.trim();
    }

    public Integer getItemTopCateId() {
        return itemTopCateId;
    }

    public void setItemTopCateId(Integer itemTopCateId) {
        this.itemTopCateId = itemTopCateId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSpecialTime() {
        return specialTime;
    }

    public void setSpecialTime(Date specialTime) {
        this.specialTime = specialTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}