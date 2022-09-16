package com.zerobase.convpay;

import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.sevice.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayMethodType;
import com.zerobase.convpay.type.PayResult;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편결이 -> 머니
        ConveniencePayService conveniencePayService = new ConveniencePayService();

        // 결제
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 1000, PayMethodType.MONEY);
        PayResponse payResponse = conveniencePayService.pay(payRequest);
        System.out.println(payResponse);

        // 취소
        PayCancelRequest payCancelRequest = new PayCancelRequest(ConvenienceType.SEVEN, 500, PayMethodType.CARD);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
        System.out.println(payCancelResponse);
    }
}
