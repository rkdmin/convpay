package com.zerobase.convpay.sevice;

import com.zerobase.convpay.type.CancelPaymentResult;
import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.type.PaymentResult;

public class MoneyAdapter implements PaymentInterface{
    public MoneyUseResult use(Integer payAmount){
        // 요청이 들어온 돈
        System.out.println("MoneyAdapter.use : " + payAmount);

        // 100만원 초과일 경우 한도초과로 실패
        if(payAmount > 1000_000){
            return MoneyUseResult.USE_FAIL;
        }

        return MoneyUseResult.USE_SUCCESS;
    }

    public MoneyUseCancelResult useCancel(Integer payCancelAmount){
        // 요청이 들어온 돈
        System.out.println("MoneyAdapter.use : " + payCancelAmount);

        // 100원 미만일 경우 한도미만으로 실패
        if(payCancelAmount < 100){
            return MoneyUseCancelResult.USE_CANCEL_FAIL;
        }

        return MoneyUseCancelResult.USE_CANCEL_SUCCESS;
    }

    @Override
    public PaymentResult payment(Integer payAmount) {
        MoneyUseResult moneyUseResult = use(payAmount);

        if(moneyUseResult == MoneyUseResult.USE_FAIL){
            return PaymentResult.PAYMENT_FAIL;
        }

        return PaymentResult.PAYMENT_SUCCESS;
    }

    @Override
    public CancelPaymentResult cancelPayment(Integer cancelAmount) {
        MoneyUseCancelResult moneyUseCancelResult = useCancel(cancelAmount);

        if(moneyUseCancelResult == MoneyUseCancelResult.USE_CANCEL_FAIL){
            return CancelPaymentResult.CANCEL_PAYMENT_FAIL;
        }

        return CancelPaymentResult.CANCEL_PAYMENT_SUCCESS;
    }
}
