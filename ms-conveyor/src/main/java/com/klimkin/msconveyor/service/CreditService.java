package com.klimkin.msconveyor.service;

import com.klimkin.msconveyor.dto.CreditDTO;
import com.klimkin.msconveyor.dto.ScoringDataDTO;

public interface CreditService {

    CreditDTO getCredit(ScoringDataDTO scoringDataDTO);
}