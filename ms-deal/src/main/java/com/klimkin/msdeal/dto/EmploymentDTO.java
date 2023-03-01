package com.klimkin.msdeal.dto;

import com.klimkin.msdeal.enums.EmploymentStatus;
import com.klimkin.msdeal.enums.Position;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Schema(description = "Applicant`s employment info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentDTO {

    @Schema(description = "Applicant`s employment status")
    private EmploymentStatus employmentStatus;

    @Schema(description = "Applicant`s INN number")
    private String employerINN;

    @Schema(description = "Applicant`s salary")
    private BigDecimal salary;

    @Schema(description = "Applicant`s employment position")
    private Position position;

    @Schema(description = "Applicant`s total work experience")
    private Integer workExperienceTotal;

    @Schema(description = "Applicant`s current work experience")
    private Integer workExperienceCurrent;
}