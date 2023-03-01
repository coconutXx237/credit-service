package com.klimkin.msdeal.entity;

import com.klimkin.msdeal.enums.ApplicationStatus;
import com.klimkin.msdeal.enums.ChangeType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatusHistory implements Serializable {

    private ApplicationStatus status;

    private LocalDateTime time;

    private ChangeType changeType;
}