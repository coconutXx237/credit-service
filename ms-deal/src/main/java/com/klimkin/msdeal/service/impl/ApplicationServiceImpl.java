package com.klimkin.msdeal.service.impl;

import com.klimkin.msdeal.dto.LoanApplicationRequestDTO;
import com.klimkin.msdeal.entity.Application;
import com.klimkin.msdeal.entity.StatusHistory;
import com.klimkin.msdeal.enums.ApplicationStatus;
import com.klimkin.msdeal.enums.ChangeType;
import com.klimkin.msdeal.repository.ApplicationRepository;
import com.klimkin.msdeal.service.ApplicationService;
import com.klimkin.msdeal.util.ApplicationNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public Application createApplication(LoanApplicationRequestDTO request, Long clientId) {
        Application newApplication = new Application();
        newApplication.setClientId(clientId);
        log.info("Added clientId={} into new application for client {} {}", clientId, request.getFirstName(), request.getLastName());
        newApplication.setCreationDate(LocalDate.now());
        log.info("Added creationDate={} into new application for client {} {}", LocalDate.now(), request.getFirstName(), request.getLastName());
        newApplication.setStatusHistory(new ArrayList<>());
        log.info("Added empty statusHistory into new application for client {} {}", request.getFirstName(), request.getLastName());


        return applicationRepository.save(newApplication);
    }

    @Override
    public Application findApplication(Long applicationId) {
        return applicationRepository.findByApplicationId(applicationId).orElseThrow(ApplicationNotFoundException::new);
    }

    @Override
    public void updateApplication(Application updatedApplication) {
        applicationRepository.save(updatedApplication);
    }

    @Override
    public List<StatusHistory> updateStatusHistoryForOffer(Application application) {
        log.info("Updating offerStage StatusHistory for applicationId={}", application.getApplicationId());
        List<StatusHistory> statusHistoryList = application.getStatusHistory();
        statusHistoryList.add(new StatusHistory(ApplicationStatus.PREAPPROVAL, LocalDateTime.now(), ChangeType.AUTOMATIC));

        log.info("ApplicationStatus set to {}, time set to {}, ChangeType set to {} for applicationId={}",
                ApplicationStatus.PREAPPROVAL, LocalDateTime.now(), ChangeType.AUTOMATIC, application.getApplicationId());
        return statusHistoryList;
    }

    @Override
    public List<StatusHistory> updateStatusHistoryForCalculation(Application application) {
        log.info("Updating calculationStage StatusHistory for applicationId={}", application.getApplicationId());
        List<StatusHistory> statusHistoryList = application.getStatusHistory();
        statusHistoryList.add(new StatusHistory(ApplicationStatus.APPROVED, LocalDateTime.now(), ChangeType.AUTOMATIC));
        log.info("ApplicationStatus set to {}, time set to {}, ChangeType set to {} for applicationId={}",
                ApplicationStatus.APPROVED, LocalDateTime.now(), ChangeType.AUTOMATIC, application.getApplicationId());
        return statusHistoryList;
    }
}