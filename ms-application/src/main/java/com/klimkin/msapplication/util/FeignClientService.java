package com.klimkin.msapplication.util;

import com.klimkin.msapplication.dto.LoanApplicationRequestDTO;
import com.klimkin.msapplication.dto.LoanOfferDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "deal", url = "http://localhost:8081/deal")
public interface FeignClientService {

    @PostMapping("/application")
    List<LoanOfferDTO> getOffer(@RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO);

    @PutMapping("/offer")
    void chooseOffer(@RequestBody LoanOfferDTO loanOfferDTO);
}