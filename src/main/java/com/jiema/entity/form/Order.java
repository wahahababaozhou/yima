package com.jiema.entity.form;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author yuqi
 * 用户上报订单
 */
@Entity
@Table(name = "farmerOrder")
public class Order implements Serializable {
    /**
     * 报单ID
     */
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Id;
    /**
     * 下单人ID
     */
    private String farmerId;
    /**
     * 发单人id
     */
    private String landlordId;
    /**
     * 发单人
     */
    private String landlordName;
    /**
     * 下单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date buyTime;
    /**
     * 付款方式（自付、代付、到付）
     */
    private String payWay;
    /**
     * 订单编号
     */
    private String orderNumber;
    /**
     * 运单编号
     */
    private String waybillNumber;
    /**
     * 商品类型
     */
    private String commodityType;
    /**
     * 手机颜色
     */
    private String colour;
    /**
     * 手机配置
     */
    private String param;
    /**
     * 下单数量
     */
    private String amount;

    /**
     * 下单平台
     */
    private String store;
    /**
     * 是否自营
     */
    private String isownCommodity;
    /**
     * 单价
     */
    private String unitPrice;
    /**
     * 回款账户  支付宝or微信
     */
    private String moneyBackPlatform;
    /**
     * 回款账户
     */
    private String moneyBackAccount;
    /**
     * 回款二维码
     */
    private String qrCode;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 结算状态
     */
    private String state;
    /**
     * 结算方式（阿里，微信）
     */
    private String settlePlatform;
    /**
     * 结算转账ID
     */
    private String settleId;

    @Override
    public String toString() {
        return "Order{" +
                "Id='" + Id + '\'' +
                ", farmerId='" + farmerId + '\'' +
                ", landlordId='" + landlordId + '\'' +
                ", landlordName='" + landlordName + '\'' +
                ", buyTime=" + buyTime +
                ", payWay='" + payWay + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", waybillNumber='" + waybillNumber + '\'' +
                ", commodityType='" + commodityType + '\'' +
                ", colour='" + colour + '\'' +
                ", param='" + param + '\'' +
                ", amount='" + amount + '\'' +
                ", store='" + store + '\'' +
                ", isownCommodity='" + isownCommodity + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", moneyBackPlatform='" + moneyBackPlatform + '\'' +
                ", moneyBackAccount='" + moneyBackAccount + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", remarks='" + remarks + '\'' +
                ", state='" + state + '\'' +
                ", settlePlatform='" + settlePlatform + '\'' +
                ", settleId='" + settleId + '\'' +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(String farmerId) {
        this.farmerId = farmerId;
    }

    public String getLandlordId() {
        return landlordId;
    }

    public void setLandlordId(String landlordId) {
        this.landlordId = landlordId;
    }

    public String getLandlordName() {
        return landlordName;
    }

    public void setLandlordName(String landlordName) {
        this.landlordName = landlordName;
    }

    public Date getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getWaybillNumber() {
        return waybillNumber;
    }

    public void setWaybillNumber(String waybillNumber) {
        this.waybillNumber = waybillNumber;
    }

    public String getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(String commodityType) {
        this.commodityType = commodityType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getIsownCommodity() {
        return isownCommodity;
    }

    public void setIsownCommodity(String isownCommodity) {
        this.isownCommodity = isownCommodity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getMoneyBackPlatform() {
        return moneyBackPlatform;
    }

    public void setMoneyBackPlatform(String moneyBackPlatform) {
        this.moneyBackPlatform = moneyBackPlatform;
    }

    public String getMoneyBackAccount() {
        return moneyBackAccount;
    }

    public void setMoneyBackAccount(String moneyBackAccount) {
        this.moneyBackAccount = moneyBackAccount;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSettlePlatform() {
        return settlePlatform;
    }

    public void setSettlePlatform(String settlePlatform) {
        this.settlePlatform = settlePlatform;
    }

    public String getSettleId() {
        return settleId;
    }

    public void setSettleId(String settleId) {
        this.settleId = settleId;
    }
}
