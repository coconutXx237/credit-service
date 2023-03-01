package com.klimkin.msdeal.entity;

import com.klimkin.msdeal.enums.EmploymentStatus;
import com.klimkin.msdeal.enums.Position;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class Employment implements Serializable {

    private Long employmentId;

    private EmploymentStatus employmentStatus;

    private BigDecimal salary;

    private Position position;

    private Integer workExperienceTotal;

    private Integer workExperienceCurrent;
}