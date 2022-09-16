package com.zerobase.convpay.sevice;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.PayMethodType;

public class DiscountByPayMethod implements DiscountInterface{
    @Override
    public Integer getDiscountedAmount(PayRequest payRequest) {
        switch(payRequest.getPayMethodType()){
            case MONEY:
                return payRequest.getPayAmount() * 7 / 10;
            case CARD:
                return payRequest.getPayAmount();
        }
        return payRequest.getPayAmount();
    }
}
