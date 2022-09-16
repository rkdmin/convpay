package com.zerobase.convpay.sevice;

import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPayMethodTest {
    DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();

    @Test
    void discountSuccess(){
        // given
        PayRequest payRequestByMoney = new PayRequest(ConvenienceType.G25, 1000, PayMethodType.MONEY);
        PayRequest payRequestByCard = new PayRequest(ConvenienceType.G25, 1000, PayMethodType.CARD);

        // when
        Integer discountPayAmountByMoney = discountByPayMethod.getDiscountedAmount(payRequestByMoney);
        Integer discountPayAmountByCard = discountByPayMethod.getDiscountedAmount(payRequestByCard);

        // then
        assertEquals(700, discountPayAmountByMoney);
        assertEquals(1000, discountPayAmountByCard);
    }
}