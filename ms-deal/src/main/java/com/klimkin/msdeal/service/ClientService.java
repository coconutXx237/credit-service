package com.klimkin.msdeal.service;

import com.klimkin.msdeal.dto.EmploymentDTO;
import com.klimkin.msdeal.dto.FinishRegistrationRequestDTO;
import com.klimkin.msdeal.dto.LoanApplicationRequestDTO;
import com.klimkin.msdeal.entity.Client;
import com.klimkin.msdeal.entity.Employment;
import com.klimkin.msdeal.entity.Passport;

public interface ClientService {

    Client createClient(LoanApplicationRequestDTO loanApplicationRequestDTO);

    Client findClient(Long clientId);

    void updateClient(Client updatedClient);

    Employment updateEmployment(EmploymentDTO employmentDTO, Long clientId);

    Passport enrichPassport(Passport passport, FinishRegistrationRequestDTO finishRegistrationRequestDTO, Client client);
}