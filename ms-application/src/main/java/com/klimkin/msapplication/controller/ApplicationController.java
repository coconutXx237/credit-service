package com.klimkin.msapplication.controller;

import com.klimkin.msapplication.dto.LoanApplicationRequestDTO;
import com.klimkin.msapplication.dto.LoanOfferDTO;
import com.klimkin.msapplication.util.FeignClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Main controller", description="provides functionality via FeignClient to send data for pre-scoring, " +
        "and to handle the chosen offer")
@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final FeignClientService feignClientService;

    @Operation(
            summary = "Get loan offer",
            description = "Sends data for pre-scoring to MS credit-conveyor"
    )
    @PostMapping()
    public List<LoanOfferDTO> getOffer(@RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO) {
        return feignClientService.getOffer(loanApplicationRequestDTO);
    }

    @Operation(
            summary = "Handle the chosen offer",
            description = "Handles the chosen offer within inner services business logic"
    )
    @PutMapping("/offer")
    public void chooseOffer(@RequestBody LoanOfferDTO loanOfferDTO) {
        feignClientService.chooseOffer(loanOfferDTO);
    }
}