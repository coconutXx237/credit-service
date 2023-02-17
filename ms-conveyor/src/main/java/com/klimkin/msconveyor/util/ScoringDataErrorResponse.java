package com.klimkin.msconveyor.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ScoringDataErrorResponse {
    private String message;
    private long timestamp;
}