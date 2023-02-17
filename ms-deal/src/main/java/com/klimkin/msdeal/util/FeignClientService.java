package com.klimkin.msdeal.util;

import com.klimkin.msdeal.dto.CreditDTO;
import com.klimkin.msdeal.dto.LoanApplicationRequestDTO;
import com.klimkin.msdeal.dto.LoanOfferDTO;
import com.klimkin.msdeal.dto.ScoringDataDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "conveyor", url = "http://localhost:8080/conveyor")
public interface FeignClientService {

    @PostMapping("/offers")
    List<LoanOfferDTO> getOffer(@RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO);

    @PostMapping("/calculation")
    CreditDTO getCalculation(@RequestBody ScoringDataDTO scoringDataDTO);
}
