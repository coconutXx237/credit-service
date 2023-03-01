package com.klimkin.msdeal.entity;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Passport implements Serializable {

    private Long passportId;

    private String series;

    private String number;

    private String issueBranch;

    private LocalDate issueDate;
}