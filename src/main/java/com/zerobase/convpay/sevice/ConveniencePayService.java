package com.zerobase.convpay.sevice;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

public class ConveniencePayService {
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private final CardAdapter cardAdapter = new CardAdapter();
    public PayResponse pay(PayRequest payRequest){
        MoneyUseResult moneyUseResult;
        CardUseResult cardUseResult;

        // 현금결제
        if(payRequest.getPayMethodType() == PayMethodType.MONEY){
            moneyUseResult = moneyAdapter.use(payRequest.getPayAmount());
        }else{// 카드결제
            cardAdapter.approval();
            cardAdapter.authorization();
            cardUseResult = cardAdapter.capture(payRequest.getPayAmount());
        }


        // fail fast
        if(moneyUseResult == MoneyUseResult.USE_FAIL || cardUseResult == CardUseResult.USE_FAIL){
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
