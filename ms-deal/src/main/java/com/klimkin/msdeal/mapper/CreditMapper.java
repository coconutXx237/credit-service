package com.klimkin.msdeal.mapper;

import com.klimkin.msdeal.dto.CreditDTO;
import com.klimkin.msdeal.entity.Credit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditMapper {

    Credit toCredit(CreditDTO creditDTO);
}