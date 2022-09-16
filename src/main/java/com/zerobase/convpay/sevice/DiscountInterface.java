package com.zerobase.convpay.sevice;

import com.zerobase.convpay.dto.PayRequest;

public interface DiscountInterface {
    Integer getDiscountedAmount(PayRequest payRequest);
}
