package com.zerobase.convpay.sevice;

import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayResult;
import com.zerobase.convpay.type.MoneyUseResult;

public class ConveniencePayService {
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    public PayResponse pay(PayRequest payRequest){
        MoneyUseResult moneyUseResult = moneyAdapter.use(payRequest.getPayAmount());

        // fail fast
        if(moneyUseResult == MoneyUseResult.USE_FAIL){
            return new PayResponse(PayResult.FAIL, 0);
        }

        // only one success case
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest){
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.payCancel(payCancelRequest.getPayCancelAmount());

        // fail fast
        if(moneyUseCancelResult == MoneyUseCancelResult.USE_CANCEL_FAIL){
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        // success
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
