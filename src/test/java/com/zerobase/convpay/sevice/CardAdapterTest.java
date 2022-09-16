package com.zerobase.convpay.sevice;

import com.zerobase.convpay.type.CardUseCancelResult;
import com.zerobase.convpay.type.CardUseResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardAdapterTest {
    private CardAdapter cardAdapter = new CardAdapter();

    @Test
    void capture_success() {
        // given
        Integer payAmount = 99;

        // when
        CardUseResult cardUseResult = cardAdapter.capture(payAmount);

        // then
        assertEquals(CardUseResult.USE_SUCCESS, cardUseResult);
    }

    @Test
    void capture_fail() {
        // given
        Integer payAmount = 101;

        // when
        CardUseResult cardUseResult = cardAdapter.capture(payAmount);

        // then
        assertEquals(CardUseResult.USE_FAIL, cardUseResult);
    }

    @Test
    void cancelCapture_success() {
        // given
        Integer payCancelAmount = 1001;
        // when
        CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(payCancelAmount);
        // then
        assertEquals(CardUseCancelResult.USE_CANCEL_SUCCESS, cardUseCancelResult);
    }


    @Test
    void cancelCapture_fail() {
        // given
        Integer payCancelAmount = 100;
        // when
        CardUseCancelResult cardUseCancelResult = cardAdapter.cancelCapture(payCancelAmount);
        // then
        assertEquals(CardUseCancelResult.USE_CANCEL_FAIL, cardUseCancelResult);
    }
}