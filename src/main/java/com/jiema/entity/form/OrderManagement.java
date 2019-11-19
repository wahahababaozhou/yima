package com.jiema.entity.form;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "order_management")
public class OrderManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 报单编码
     */
    private String code;
    /**
     * 抢购订单发布人编码
     */
    private String publisherCode;
    /**
     * 提交人编码
     */
    private String submitterCode;
    /**
     * 下单网站
     */
    private String store;
    /**
     * 物流运单号
     * 注：苏宁报订单号 （天猫苏宁报名字+电话 多账号误重复使用）
     */
    private String trackingNumber;
    /**
     * 机型+配置+颜色
     */
    private String model;
    /**
     * 下单数量
     */
    private String amount;
    /**
     * 下单价格
     */
    private String orderPrice;
    /**
     * 付款方式
     */
    private String paymentMethod;

    /**
     * 到货时间
     */
    private String arrivalDate;
    /**
     * 收件人
     */
    private String addressee;

    /**
     * 收款人
     */
    private String payee;

    /**
     * 收款支付宝
     */
    private String alipayAccount;
    /**
     * QQ
     */
    private String qq;
    /**
     * 处理状态
     */
    private String state;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 报单时间
     */
    private Date createDate;

    @Override
    public String toString() {
        return "OrderManagement{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", publisherCode='" + publisherCode + '\'' +
                ", submitterCode='" + submitterCode + '\'' +
                ", store='" + store + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", model='" + model + '\'' +
                ", amount='" + amount + '\'' +
                ", orderPrice='" + orderPrice + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", addressee='" + addressee + '\'' +
                ", payee='" + payee + '\'' +
                ", alipayAccount='" + alipayAccount + '\'' +
                ", qq='" + qq + '\'' +
                ", state='" + state + '\'' +
                ", remarks='" + remarks + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderManagement that = (OrderManagement) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(code, that.code) &&
                Objects.equals(publisherCode, that.publisherCode) &&
                Objects.equals(submitterCode, that.submitterCode) &&
                Objects.equals(store, that.store) &&
                Objects.equals(trackingNumber, that.trackingNumber) &&
                Objects.equals(model, that.model) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(orderPrice, that.orderPrice) &&
                Objects.equals(paymentMethod, that.paymentMethod) &&
                Objects.equals(arrivalDate, that.arrivalDate) &&
                Objects.equals(addressee, that.addressee) &&
                Objects.equals(payee, that.payee) &&
                Objects.equals(alipayAccount, that.alipayAccount) &&
                Objects.equals(qq, that.qq) &&
                Objects.equals(state, that.state) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(createDate, that.createDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, publisherCode, submitterCode, store, trackingNumber, model, amount, orderPrice, paymentMethod, arrivalDate, addressee, payee, alipayAccount, qq, state, remarks, createDate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPublisherCode() {
        return publisherCode;
    }

    public void setPublisherCode(String publisherCode) {
        this.publisherCode = publisherCode;
    }

    public String getSubmitterCode() {
        return submitterCode;
    }

    public void setSubmitterCode(String submitterCode) {
        this.submitterCode = submitterCode;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
