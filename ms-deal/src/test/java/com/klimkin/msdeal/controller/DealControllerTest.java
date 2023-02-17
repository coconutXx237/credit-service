package com.klimkin.msdeal.controller;

import com.klimkin.msdeal.dto.FinishRegistrationRequestDTO;
import com.klimkin.msdeal.dto.LoanApplicationRequestDTO;
import com.klimkin.msdeal.dto.LoanOfferDTO;
import com.klimkin.msdeal.service.impl.DealHandleServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DealControllerTest {
    @InjectMocks
    private DealController dealController;

    @Mock
    private DealHandleServiceImpl dealHandleService;

    @Test
    void getOffer() {
        LoanApplicationRequestDTO loanApplicationRequestDTO = getLoanApplicationRequestDTO();
        List<LoanOfferDTO> loanOfferDTOList = new ArrayList<>();
        when(dealHandleService.handleApplicationStage(loanApplicationRequestDTO)).thenReturn(loanOfferDTOList);

        assertNotNull(dealController.getOffer(loanApplicationRequestDTO));
        assertEquals(loanOfferDTOList.size(), dealController.getOffer(loanApplicationRequestDTO).size());
        assertEquals(loanOfferDTOList, dealController.getOffer(loanApplicationRequestDTO));
    }

    @Test
    void ChooseOffer() {
        LoanOfferDTO loanOfferDTO = new LoanOfferDTO();
        dealController.chooseOffer(loanOfferDTO);
        verify(dealHandleService, times(1)).handleOfferStage(argThat((LoanOfferDTO offer) ->
        offer.equals(loanOfferDTO)));

    }

    @Test
    void getCalculation() {
        Long applicationId = 6L;
        FinishRegistrationRequestDTO finishRegistrationRequestDTO = new FinishRegistrationRequestDTO();
        dealController.getCalculation(finishRegistrationRequestDTO, applicationId);
        verify(dealHandleService).handleCalculationStage(finishRegistrationRequestDTO, applicationId);
    }

    private LoanApplicationRequestDTO getLoanApplicationRequestDTO() {
        return new LoanApplicationRequestDTO(
                new BigDecimal("300000"), 18, "Ivan", "Ivanov", "Ivanovich", "example@mail.ru",
                LocalDate.of(1993, Month.DECEMBER, 3), "1234", "123456"
        );
    }
}