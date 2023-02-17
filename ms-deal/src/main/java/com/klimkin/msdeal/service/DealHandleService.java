package com.klimkin.msdeal.service;

import com.klimkin.msdeal.dto.FinishRegistrationRequestDTO;
import com.klimkin.msdeal.dto.LoanApplicationRequestDTO;
import com.klimkin.msdeal.dto.LoanOfferDTO;

import java.util.List;

public interface DealHandleService {

    List<LoanOfferDTO> handleApplicationStage(LoanApplicationRequestDTO request);

    void handleOfferStage(LoanOfferDTO loanOfferDTO);

    void handleCalculationStage(FinishRegistrationRequestDTO finishRegistrationRequestDTO, Long applicationId);
}