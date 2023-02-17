package com.klimkin.msconveyor.service;

import com.klimkin.msconveyor.dto.PaymentScheduleElement;
import com.klimkin.msconveyor.dto.ScoringDataDTO;

import java.math.BigDecimal;
import java.util.List;

public interface CalculationService {
    BigDecimal calculateOfferRate(boolean isInsuranceEnabled, boolean isSalaryClient);
    BigDecimal calculateMonthlyPayment(BigDecimal requestedAmount, Integer term, BigDecimal annuityRatio,
                                       boolean isInsuranceEnabled);
    BigDecimal calculateTotalAmount(BigDecimal monthlyPayment, Integer term);
    BigDecimal calculateCreditRate(ScoringDataDTO scoringDataDTO);
    BigDecimal calculatePSK(BigDecimal amount, Integer term, BigDecimal monthlyPayment);
    List<PaymentScheduleElement> calculatePaymentSchedule(BigDecimal amount, Integer term, BigDecimal rate, BigDecimal monthlyPayment);

}