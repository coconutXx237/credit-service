package com.klimkin.msdeal.service;

import com.klimkin.msdeal.dto.CreditDTO;
import com.klimkin.msdeal.dto.FinishRegistrationRequestDTO;
import com.klimkin.msdeal.entity.Application;
import com.klimkin.msdeal.entity.Client;
import com.klimkin.msdeal.entity.Credit;

public interface CreditService {

    Credit toCredit(CreditDTO creditDTO);

    void createCredit(Credit credit);

    CreditDTO getCalculation(FinishRegistrationRequestDTO finishRegistrationRequestDTO,
                             Application application, Client client);
}