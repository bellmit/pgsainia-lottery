package com.pgsainia.lottery.domain.activity.model.vo;

/**
 * @author nifujia
 * @description 活动变更状态对象
 * @date 2021/11/24
 */
public class AlterStateVO {
    /**
     * 活动 id
     */
    private String activityId;
    /**
     * 变更前状态
     */
    private Integer beforeState;
    /**
     * 变更后状态
     */
    private Integer afterState;

    public AlterStateVO() {
    }

    public AlterStateVO(String activityId, Integer beforeState, Integer afterState) {
        this.activityId = activityId;
        this.beforeState = beforeState;
        this.afterState = afterState;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public Integer getBeforeState() {
        return beforeState;
    }

    public void setBeforeState(Integer beforeState) {
        this.beforeState = beforeState;
    }

    public Integer getAfterState() {
        return afterState;
    }

    public void setAfterState(Integer afterState) {
        this.afterState = afterState;
    }

    @Override
    public String toString() {
        return "AlterStateVO{" +
                "activityId='" + activityId + '\'' +
                ", beforeState=" + beforeState +
                ", afterState=" + afterState +
                '}';
    }
}
