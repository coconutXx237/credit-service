package com.klimkin.msdeal.service.impl;

import com.klimkin.msdeal.dto.*;
import com.klimkin.msdeal.entity.Application;
import com.klimkin.msdeal.entity.Client;
import com.klimkin.msdeal.entity.Passport;
import com.klimkin.msdeal.mapper.CreditMapper;
import com.klimkin.msdeal.repository.CreditRepository;
import com.klimkin.msdeal.util.FeignClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreditServiceImplTest {
    @InjectMocks
    private CreditServiceImpl creditService;

    @Mock
    private CreditRepository creditRepository;
    @Mock
    private CreditMapper creditMapper;
    @Mock
    private FeignClientService feignClientService;


    @Test
    void toCredit() {

    }

    @Test
    void createCredit() {
    }

    @Test
    void getCalculation() {
        CreditDTO creditDTO = CreditDTO.builder().build();
        when(feignClientService.getCalculation(getScoringDataDTO(getFinishDTO(), getClient(), getApplication())))
                .thenReturn(CreditDTO.builder().build());
        ScoringDataDTO scoringDataDTO = getScoringDataDTO(getFinishDTO(), getClient(), getApplication());


        assertEquals(creditService.getCalculation(getFinishDTO(), getApplication(), getClient()), creditDTO);
        assertEquals(feignClientService.getCalculation(scoringDataDTO), CreditDTO.builder().build());
    }

    private Application getApplication() {
        Application application = new Application();
        LoanOfferDTO offer = new LoanOfferDTO();
        application.setAppliedOffer(offer);
        return application;
    }

    private FinishRegistrationRequestDTO getFinishDTO() {
        FinishRegistrationRequestDTO finishRegistrationRequestDT = new FinishRegistrationRequestDTO();
        EmploymentDTO employmentDTO = new EmploymentDTO();
        finishRegistrationRequestDT.setEmployment(employmentDTO);
        return finishRegistrationRequestDT;
    }

    private Client getClient() {
        Client client = new Client();
        Passport passport = new Passport();
        client.setPassport(passport);
        return client;
    }

    private ScoringDataDTO getScoringDataDTO(FinishRegistrationRequestDTO finishRegistrationRequestDTO, Client client,
                                             Application application) {
        return ScoringDataDTO.builder()
                .amount(application.getAppliedOffer().getRequestedAmount())
                .term(application.getAppliedOffer().getTerm())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .middleName(client.getMiddleName())
                .gender(finishRegistrationRequestDTO.getGender())
                .birthDate(client.getBirthDate())
                .passportSeries(client.getPassport().getSeries())
                .passportNumber(client.getPassport().getNumber())
                .passportIssueDate(finishRegistrationRequestDTO.getPassportIssueDate())
                .passportIssueBranch(finishRegistrationRequestDTO.getPassportIssueBranch())
                .maritalStatus(finishRegistrationRequestDTO.getMaritalStatus())
                .dependentAmount(finishRegistrationRequestDTO.getDependentAmount())
                .employment(finishRegistrationRequestDTO.getEmployment())
                .account(finishRegistrationRequestDTO.getAccount())
                .isInsuranceEnabled(application.getAppliedOffer().getIsInsuranceEnabled())
                .isSalaryClient(application.getAppliedOffer().getIsSalaryClient()).build();
    }
}