package com.klimkin.msdeal.dto;

import com.klimkin.msdeal.enums.ApplicationStatus;
import com.klimkin.msdeal.enums.ChangeType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Schema(description = "DTO to be enriched with status history for application")

@Data
@Builder
public class ApplicationStatusHistoryDTO {

    @Schema(description = "Application status")
    private ApplicationStatus applicationStatus;

    @Schema(description = "Date of update of status history")
    private LocalDate time;

    @Schema(description = "How the status was changed")
    private ChangeType changeType;
}