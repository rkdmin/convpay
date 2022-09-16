package com.zerobase.convpay.sevice;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConvenienceTest {
    DiscountByConvenience discountByConvenience = new DiscountByConvenience();
    
    @Test
    void discountTest(){
        // given
        PayRequest payRequestG25 = new PayRequest(ConvenienceType.G25, 1000, PayMethodType.MONEY);
        PayRequest payRequestGU = new PayRequest(ConvenienceType.GU, 1000, PayMethodType.MONEY);
        PayRequest payRequestSEVEN = new PayRequest(ConvenienceType.SEVEN, 1000, PayMethodType.MONEY);

        // when
        Integer discountedAmountG25 = discountByConvenience.getDiscountedAmount(payRequestG25);
        Integer discountedAmountGU = discountByConvenience.getDiscountedAmount(payRequestGU);
        Integer discountedAmountSEVEN = discountByConvenience.getDiscountedAmount(payRequestSEVEN);

        // then
        assertEquals(800, discountedAmountG25);
        assertEquals(900, discountedAmountGU);
        assertEquals(1000, discountedAmountSEVEN);
    }

}