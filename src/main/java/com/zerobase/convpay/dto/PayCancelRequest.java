package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;

public class PayCancelRequest {
    // 가맹점
    ConvenienceType convenienceType;

    // 결제 취소 금액
    Integer payCancelAmount;

    public PayCancelRequest(ConvenienceType convenienceType, Integer payCancelAmount) {
        this.convenienceType = convenienceType;
        this.payCancelAmount = payCancelAmount;
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
}
