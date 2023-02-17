package com.klimkin.msconveyor.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class LoanApplicationRequestErrorResponse {
    private String message;
    private long timestamp;
}