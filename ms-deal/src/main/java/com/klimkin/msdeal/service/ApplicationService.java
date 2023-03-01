package com.klimkin.msdeal.service;

import com.klimkin.msdeal.dto.LoanApplicationRequestDTO;
import com.klimkin.msdeal.entity.Application;
import com.klimkin.msdeal.entity.StatusHistory;

import java.util.List;

public interface ApplicationService {

    Application createApplication(LoanApplicationRequestDTO request, Long clientId);

    Application findApplication(Long id);

    void updateApplication(Application updatedApplication);

    List<StatusHistory> updateStatusHistoryForOffer(Application application);

    List<StatusHistory> updateStatusHistoryForCalculation(Application application);
}