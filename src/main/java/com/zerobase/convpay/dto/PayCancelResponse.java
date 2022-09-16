package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayCancelResult;

public class PayCancelResponse {
    // 성공 여부
    PayCancelResult payCancelResult;

    // 결제취소금액
    Integer payCancelAmount;

    public PayCancelResponse(PayCancelResult payCancelResult, Integer payCancelAmount) {
        this.payCancelResult = payCancelResult;
        this.payCancelAmount = payCancelAmount;
    }

    public PayCancelResult getPayCancelResult() {
        return payCancelResult;
    }

    public void setPayCancelResult(PayCancelResult payCancelResult) {
        this.payCancelResult = payCancelResult;
    }

    public Integer getPayCancelAmount() {
        return payCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        this.payCancelAmount = payCancelAmount;
    }

    @Override
    public String toString() {
        return "PayCancelResponse{" +
                "payCancelResult=" + payCancelResult +
                ", payCancelAmount=" + payCancelAmount +
                '}';
    }
}
