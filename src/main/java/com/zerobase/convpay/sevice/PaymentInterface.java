package com.zerobase.convpay.sevice;

import com.zerobase.convpay.type.CancelPaymentResult;
import com.zerobase.convpay.type.PaymentResult;

public interface PaymentInterface {
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelAmount);
}
