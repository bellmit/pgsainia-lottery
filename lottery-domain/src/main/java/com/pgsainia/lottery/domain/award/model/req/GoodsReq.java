package com.pgsainia.lottery.domain.award.model.req;

import com.pgsainia.lottery.domain.award.model.vo.ShippingAddress;

/**
 * @author nifujia
 * @date 2021/11/21 20:51
 * @description 奖品发货信息
 */
public class GoodsReq {
    /**
     * 用户 id
     */
    private String uId;
    /**
     * 抽奖单号 id
     */
    private String orderId;
    /**
     * 奖品 id
     */
    private String awardId;
    /**
     * 奖品名称
     */
    private String awardName;
    /**
     * 奖品内容（文字描述信息，兑奖码，sku）
     */
    private String awardContent;
    /**
     * 四级送货地址（只有实物奖品才有收货地址）
     */
    private ShippingAddress shippingAddress;

    /**
     * 扩展信息，用于一些个性商品发放所需要的透传字段展示
     */
    private String extInfo;

    public GoodsReq(String uId, String orderId, String awardId, String awardName, String awardContent) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
        this.awardName = awardName;
        this.awardContent = awardContent;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardContent() {
        return awardContent;
    }

    public void setAwardContent(String awardContent) {
        this.awardContent = awardContent;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }
}