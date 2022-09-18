package com.zerobase.convpay.sevice;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ConveniencePayService {
    private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap = new HashMap<>();
    private final DiscountInterface discountInterface;

    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet, DiscountInterface discountInterface) {
        paymentInterfaceSet.forEach(
                paymentInterface -> paymentInterfaceMap.put(paymentInterface.getPayMethodType(), paymentInterface)
        );
        this.discountInterface = discountInterface;
    }

    public PayResponse pay(PayRequest payRequest){
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payRequest.getPayMethodType());

        // 할인 적용
        Integer discountedAmount =  discountInterface.getDiscountedAmount(payRequest);

        // 이렇게 합치면 card인지 money인지 알필요없이 실행됨
        PaymentResult paymentResult = paymentInterface.payment(discountedAmount);

        // 실패
        if(paymentResult == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        // 성공
        return new PayResponse(PayResult.SUCCESS, discountedAmount);
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest){
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payCancelRequest.getPayMethodType());

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        // 실패
        if(cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL){
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
