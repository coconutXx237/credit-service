package com.klimkin.msdeal.mapper;

import com.klimkin.msdeal.dto.EmploymentDTO;
import com.klimkin.msdeal.entity.Employment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmploymentMapper {

    Employment toEmployment(EmploymentDTO employmentDTO);
}