package com.zerobase.convpay;

import com.zerobase.convpay.config.ApplicationConfig;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.sevice.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayMethodType;
import com.zerobase.convpay.type.PayResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편결이 -> 머니
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ConveniencePayService conveniencePayService = applicationContext.getBean("conveniencePayService", ConveniencePayService.class);

        // 결제
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 50, PayMethodType.CARD);
        PayResponse payResponse = conveniencePayService.pay(payRequest);
        System.out.println(payResponse);

        // 취소
        PayCancelRequest payCancelRequest = new PayCancelRequest(ConvenienceType.SEVEN, 500, PayMethodType.MONEY);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
        System.out.println(payCancelResponse);
    }
}
