package com.klimkin.msdeal.service.impl;

import com.klimkin.msdeal.dto.LoanApplicationRequestDTO;
import com.klimkin.msdeal.dto.LoanOfferDTO;
import com.klimkin.msdeal.entity.Application;
import com.klimkin.msdeal.entity.Client;
import com.klimkin.msdeal.util.FeignClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DealHandleServiceImplTest {
    @InjectMocks
    private DealHandleServiceImpl dealHandleService;
    @Mock
    private ClientServiceImpl clientService;
    @Mock
    private ApplicationServiceImpl applicationService;
    @Mock
    private CreditServiceImpl creditService;
    @Mock
    private FeignClientService feignClientService;

    @Test
    void handleApplicationStage() {
        LoanApplicationRequestDTO loanApplicationRequestDTO = getRequestDTO();
        List<LoanOfferDTO> testLoanOfferDTOList = getLoanOfferDTOList();

        when(clientService.createClient(loanApplicationRequestDTO)).thenReturn(new Client());
        when(applicationService.createApplication(loanApplicationRequestDTO,  null)).thenReturn(new Application());
        when(dealHandleService.handleApplicationStage(loanApplicationRequestDTO)).thenReturn(testLoanOfferDTOList);

        Client client = clientService.createClient(loanApplicationRequestDTO);
        Application application = applicationService.createApplication(loanApplicationRequestDTO, client.getClientId());
        List<LoanOfferDTO> loanOfferDTOList = feignClientService.getOffer(loanApplicationRequestDTO);
        loanOfferDTOList.forEach(e -> e.setOfferApplicationId(application.getApplicationId()));

        assertEquals(dealHandleService.handleApplicationStage(loanApplicationRequestDTO), testLoanOfferDTOList);
    }

    @Test
    void handleOfferStage() {
    }

    @Test
    void handleCalculationStage() {
    }

    private LoanApplicationRequestDTO getRequestDTO() {
        return new LoanApplicationRequestDTO(
                new BigDecimal("300000"), 18, "Ivan", "Ivanov", "Ivanovich", "example@mail.ru",
                LocalDate.of(1993, Month.DECEMBER, 3), "1234", "123456"
        );
    }

    private List<LoanOfferDTO> getLoanOfferDTOList() {
        return List.of(
                new LoanOfferDTO(1L, new BigDecimal("300000"), new BigDecimal("336877.92"),
                        18, new BigDecimal("18715.44"), new BigDecimal("15"), false, false),
                new LoanOfferDTO(1L, new BigDecimal("300000"), new BigDecimal("334443.24"),
                        18, new BigDecimal("18580.18"), new BigDecimal("14"), false, true),
                new LoanOfferDTO(1L, new BigDecimal("300000"), new BigDecimal("340851.42"),
                        18, new BigDecimal("18936.19"), new BigDecimal("10"), true, false),
                new LoanOfferDTO(1L, new BigDecimal("300000"), new BigDecimal("338347.80"),
                        18, new BigDecimal("18797.10"), new BigDecimal("9"), true, true));
    }
}