package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayResult;

public class PayResponse {
    // 결제 결과
    PayResult payResult;

    // 결제 성공 금액
    Integer payAmount;

    public PayResponse(PayResult payResult, Integer payAmount) {
        this.payResult = payResult;
        this.payAmount = payAmount;
    }

    public PayResult getPayResult() {
        return payResult;
    }

    public void setPayResult(PayResult payResult) {
        this.payResult = payResult;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.payAmount = paidAmount;
    }
}
