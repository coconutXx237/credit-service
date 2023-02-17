package com.klimkin.msconveyor.util;

public class LoanApplicationRequestErrorException extends RuntimeException {
    public LoanApplicationRequestErrorException(String msg){
        super(msg);
    }
}