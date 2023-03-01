package com.klimkin.msdeal.mapper;

import com.klimkin.msdeal.dto.LoanApplicationRequestDTO;
import com.klimkin.msdeal.entity.Client;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toClient(LoanApplicationRequestDTO loanApplicationRequestDTO);
}