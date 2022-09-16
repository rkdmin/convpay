package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;

public class PayRequest {
    // 편의점 종류
    ConvenienceType convenienceType;

    // 결제금액
    Integer payAmount;
    PayMethodType payMethodType;

    public PayRequest(ConvenienceType convenienceType, Integer payAmount, PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }
}
