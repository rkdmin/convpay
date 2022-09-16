package com.zerobase.convpay.sevice;

import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;

public class MoneyAdapter {
    public MoneyUseResult use(Integer payAmount){
        // 요청이 들어온 돈
        System.out.println("MoneyAdapter.use : " + payAmount);

        // 100만원 초과일 경우 한도초과로 실패
        if(payAmount > 1000_000){
            return MoneyUseResult.USE_FAIL;
        }

        return MoneyUseResult.USE_SUCCESS;
    }

    public MoneyUseCancelResult payCancel(Integer payCancelAmount){
        // 요청이 들어온 돈
        System.out.println("MoneyAdapter.use : " + payCancelAmount);

        // 100원 미만일 경우 한도미만으로 실패
        if(payCancelAmount < 100){
            return MoneyUseCancelResult.USE_CANCEL_FAIL;
        }

        return MoneyUseCancelResult.USE_CANCEL_SUCCESS;
    }
}
