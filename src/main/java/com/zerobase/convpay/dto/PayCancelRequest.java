package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;

public class PayCancelRequest {
    // 가맹점
    ConvenienceType convenienceType;

    // 결제 취소 금액
    Integer payCancelAmount;

    // 결제 타입
    PayMethodType payMethodType;

    public PayCancelRequest(ConvenienceType convenienceType, Integer payCancelAmount, PayMethodType payMethodType) {
        this.convenienceType = convenienceType;
        this.payCancelAmount = payCancelAmount;
        this.payMethodType = payMethodType;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayCancelAmount() {
        return payCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        this.payCancelAmount = payCancelAmount;
    }

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }
}
