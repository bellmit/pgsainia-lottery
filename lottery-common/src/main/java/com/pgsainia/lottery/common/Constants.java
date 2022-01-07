package com.pgsainia.lottery.common;

/**
 * @author nifujia
 * @description
 * @date 2021/11/15
 */
public class Constants {

    public enum ResponseCode {

        SUCCESS("0000", "成功"),
        UN_ERROR("0001", "未知错误"),
        ILLEGAL_PARAMETER("0002", "非法参数"),
        INDEX_DUP("0003", "主键冲突"),
        ;
        private String code;
        private String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }

    /**
     * 抽奖策略模式：总体概率、单项概率
     * 场景：两种抽奖算法描述，场景A20%、B30%、C50%
     * 单项概率：如果A奖品抽空后，B和C保持目前中奖概率，用户抽奖扔有20%中为A，因A库存抽空则结果展示为未中奖。为了运营成本，通常这种情况的使用的比较多
     * 总体概率：如果A奖品抽空后，B和C奖品的概率按照 3:5 均分，相当于B奖品中奖概率由 0.3 升为 0.375
     */
    public enum StrategyMode {
        SINGLE(1, "单项概率"),
        ENTIRETY(2, "总体概率"),
        ;
        private Integer code;
        private String info;

        StrategyMode(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    /**
     * 中奖状态：0未中奖、1已中奖、2兜底奖
     */
    public enum DrawState {
        FAIL(0, "未中奖"),
        SUCCESS(1, "已中奖"),
        COVER(2, "兜底奖"),
        ;
        private Integer code;
        private String info;

        DrawState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    /**
     * 发奖状态：0-等待发奖，1-发奖成功，2-发奖失败
     */
    public enum AwardState {
        WAIT(0, "等待发奖"),
        SUCCESS(1, "发奖成功"),
        FAILURE(2, "发奖失败"),
        ;
        private Integer code;
        private String info;

        AwardState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    /**
     * 奖品类型，1-文字描述，2-兑奖码，3-优惠券，4-实物商品
     */
    public enum AwardType {
        DESC(1, "文字描述"),
        REDEEM_CODE_GOODS(2, "兑换码"),
        COUPON_GOODS(3, "优惠券"),
        PHYSICAL_GOODS(4, "实物商品"),
        ;
        private Integer code;
        private String info;

        AwardType(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    /**
     * 活动状态
     */
    public enum ActivityState {
        EDIT(1, "编辑"),
        ARRAIGNMENT(2, "提审"),
        REVOKE(3, "撤审"),
        PASS(4, "通过"),
        DOING(5, "进行（活动中）"),
        REFUSE(6, "拒绝"),
        CLOSE(7, "关闭"),
        OPEN(8, "开启"),
        ;
        private Integer code;
        private String info;

        ActivityState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    /**
     * Ids 生成策略枚举
     */
    public enum Ids {
        /**
         * 雪花算法
         */
        SnowFlake,
        /**
         * 日期算法
         */
        ShortCode,
        /**
         * 随机算法
         */
        RandomNumeric;
    }

}
