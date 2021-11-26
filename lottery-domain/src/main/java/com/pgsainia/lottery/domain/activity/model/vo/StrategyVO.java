package com.pgsainia.lottery.domain.activity.model.vo;

import java.util.Date;
import java.util.List;

/**
 * @author nifujia
 * @description 策略配置信息
 * @date 2021/11/23
 */
public class StrategyVO {
    /**
     * 策略 id
     */
    private Long strategyId;
    /**
     * 策略描述
     */
    private String strategyDesc;
    /**
     * 策略方式，1-单项概率，2-总体概率
     */
    private Integer strategyMode;
    /**
     * 发放奖品方式，1-即时，2-定时，3-人工
     */
    private Integer grantType;
    /**
     * 发放奖品时间
     */
    private Date grantDate;
    /**
     * 扩展信息
     */
    private String extInfo;

    /**
     * 策略明细配置
     */
    private List<StrategyDetailVO> strategyDetailList;

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public String getStrategyDesc() {
        return strategyDesc;
    }

    public void setStrategyDesc(String strategyDesc) {
        this.strategyDesc = strategyDesc;
    }

    public Integer getStrategyMode() {
        return strategyMode;
    }

    public void setStrategyMode(Integer strategyMode) {
        this.strategyMode = strategyMode;
    }

    public Integer getGrantType() {
        return grantType;
    }

    public void setGrantType(Integer grantType) {
        this.grantType = grantType;
    }

    public Date getGrantDate() {
        return grantDate;
    }

    public void setGrantDate(Date grantDate) {
        this.grantDate = grantDate;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public List<StrategyDetailVO> getStrategyDetailList() {
        return strategyDetailList;
    }

    public void setStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        this.strategyDetailList = strategyDetailList;
    }

    @Override
    public String toString() {
        return "StrategyBriefVO{" +
                "strategyId=" + strategyId +
                ", strategyDesc='" + strategyDesc + '\'' +
                ", strategyMode=" + strategyMode +
                ", grantType=" + grantType +
                ", grantDate=" + grantDate +
                ", extInfo='" + extInfo + '\'' +
                ", strategyDetailList='" + strategyDetailList + '\'' +
                '}';
    }
}
