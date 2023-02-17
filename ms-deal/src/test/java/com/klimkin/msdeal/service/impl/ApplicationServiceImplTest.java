package com.klimkin.msdeal.service.impl;

import com.klimkin.msdeal.dto.LoanApplicationRequestDTO;
import com.klimkin.msdeal.entity.Application;
import com.klimkin.msdeal.entity.StatusHistory;
import com.klimkin.msdeal.enums.ApplicationStatus;
import com.klimkin.msdeal.enums.ChangeType;
import com.klimkin.msdeal.repository.ApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceImplTest {
    @InjectMocks
    private ApplicationServiceImpl applicationService;

    @Mock
    private ApplicationRepository applicationRepository;

    @Test
    void createApplication() {
        Application newApplication = new Application();
        when(applicationRepository.save(newApplication)).thenReturn(newApplication);
        assertEquals(applicationRepository.save(newApplication), newApplication);

        newApplication.setClientId(6L);
        newApplication.setCreationDate(LocalDate.now());
        newApplication.setStatusHistory(new ArrayList<>());

        LoanApplicationRequestDTO request = new LoanApplicationRequestDTO();
        Application createdApplication = applicationService.createApplication(request, 6L);
        assertEquals(createdApplication, newApplication);
    }

    @Test
    void findApplication() {
        Long applicationId = 6L;
        Optional<Application> newApplication = Optional.of(new Application());
        when(applicationRepository.findByApplicationId(applicationId)).thenReturn(newApplication);
        assertEquals(applicationRepository.findByApplicationId(applicationId), newApplication);

        assertEquals(applicationService.findApplication(applicationId), new Application());
    }

    @Test
    void updateApplication() {
        Application updatedApplication = new Application();
        when(applicationRepository.save(updatedApplication)).thenReturn(updatedApplication);
        assertEquals(applicationRepository.save(updatedApplication), updatedApplication);
    }

    @Test
    void updateStatusHistoryForOffer() {
        Application application = new Application();
        application.setStatusHistory(new ArrayList<>());

        List<StatusHistory> statusHistoryList = application.getStatusHistory();
        statusHistoryList.add(new StatusHistory(ApplicationStatus.PREAPPROVAL, LocalDateTime.now(), ChangeType.AUTOMATIC));


        assertEquals(applicationService.updateStatusHistoryForOffer(application), statusHistoryList);
    }

    @Test
    void updateStatusHistoryForCalculation() {
        Application application = new Application();
        application.setStatusHistory(new ArrayList<>());

        List<StatusHistory> statusHistoryList = application.getStatusHistory();
        statusHistoryList.add(new StatusHistory(ApplicationStatus.APPROVED, LocalDateTime.now(), ChangeType.AUTOMATIC));


        assertEquals(applicationService.updateStatusHistoryForCalculation(application), statusHistoryList);
    }
}