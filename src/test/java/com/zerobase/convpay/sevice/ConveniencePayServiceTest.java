package com.zerobase.convpay.sevice;

import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayMethodType;
import com.zerobase.convpay.type.PayResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConveniencePayServiceTest {
    ConveniencePayService conveniencePayService = new ConveniencePayService();

    @Test
    void pay_success(){
        // given
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 1000_000, PayMethodType.MONEY);

        // when
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        // then
        assertEquals(PayResult.SUCCESS, payResponse.getPayResult());
        assertEquals(1000_000, payResponse.getPayAmount());

    }

    @Test
    void pay_fail(){
        // given
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 1000_001, PayMethodType.MONEY);

        // when
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        // then
        assertEquals(PayResult.FAIL, payResponse.getPayResult());
        assertEquals(0, payResponse.getPayAmount());

    }

    @Test
    void pay_cancel_success(){
        // given
        PayCancelRequest payCancelRequest = new PayCancelRequest(ConvenienceType.SEVEN, 10000, PayMethodType.MONEY);

        // when
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        // then
        assertEquals(PayCancelResult.PAY_CANCEL_SUCCESS,  payCancelResponse.getPayCancelResult());
        assertEquals(10000, payCancelResponse.getPayCancelAmount());
    }

    @Test
    void pay_cancel_fail(){
        // given
        PayCancelRequest payCancelRequest = new PayCancelRequest(ConvenienceType.SEVEN, 10, PayMethodType.MONEY);

        // when
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        // then
        assertEquals(PayCancelResult.PAY_CANCEL_FAIL,  payCancelResponse.getPayCancelResult());
        assertEquals(0, payCancelResponse.getPayCancelAmount());
    }

}