package com.klimkin.msconveyor.service;

import com.klimkin.msconveyor.dto.LoanApplicationRequestDTO;
import com.klimkin.msconveyor.dto.LoanOfferDTO;

import java.util.List;

public interface OfferService {

    List<LoanOfferDTO> getOfferList(LoanApplicationRequestDTO loanApplicationRequestDTO);

}