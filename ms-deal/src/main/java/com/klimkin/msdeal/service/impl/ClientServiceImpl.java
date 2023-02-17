package com.klimkin.msdeal.service.impl;

import com.klimkin.msdeal.dto.EmploymentDTO;
import com.klimkin.msdeal.dto.FinishRegistrationRequestDTO;
import com.klimkin.msdeal.dto.LoanApplicationRequestDTO;
import com.klimkin.msdeal.entity.Client;
import com.klimkin.msdeal.entity.Employment;
import com.klimkin.msdeal.entity.Passport;
import com.klimkin.msdeal.mapper.ClientMapper;
import com.klimkin.msdeal.mapper.EmploymentMapper;
import com.klimkin.msdeal.repository.ClientRepository;
import com.klimkin.msdeal.service.ClientService;
import com.klimkin.msdeal.util.ClientNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    private final EmploymentMapper employmentMapper;

    public Client createClient(LoanApplicationRequestDTO request) {
        Client client = clientMapper.toClient(request);
        Passport passport = new Passport();
        passport.setSeries(request.getPassportSeries());
        passport.setNumber(request.getPassportNumber());
        client.setPassport(passport);
        log.info("Set passportSeries to {}, set passportNumber to {} for client {} {}",
                request.getPassportSeries(), request.getPassportNumber(), request.getFirstName(), request.getLastName());
        return clientRepository.save(client);
    }

    @Override
    public Client findClient(Long clientId) {
        return clientRepository.findById(clientId).orElseThrow(ClientNotFoundException::new);
    }

    @Override
    public void updateClient(Client updatedClient) {
        clientRepository.save(updatedClient);
    }

    @Override
    public Employment updateEmployment(EmploymentDTO employmentDTO, Long clientId) {
        Employment employment = employmentMapper.toEmployment(employmentDTO);
        log.info("Mapped EmploymentDTO to Employment entity object for clientId={}", clientId);
        employment.setEmploymentId(clientId);
        log.info("Set employmentId as {} for clientId={}", clientId, clientId);
        return employment;
    }

    @Override
    public Passport enrichPassport(Passport passport, FinishRegistrationRequestDTO finishRegistrationRequestDTO, Client client) {
        passport.setIssueBranch(finishRegistrationRequestDTO.getPassportIssueBranch());
        log.info("Passport issue branch set to {} for clientId={}", finishRegistrationRequestDTO.getPassportIssueBranch(),
                client.getClientId());
        passport.setIssueDate(finishRegistrationRequestDTO.getPassportIssueDate());
        log.info("Passport issue date set to {} for clientId={}", finishRegistrationRequestDTO.getPassportIssueDate(),
                client.getClientId());
        passport.setPassportId(client.getClientId());
        log.info("Passport ID set to {} for clientId={}", client.getClientId(), client.getClientId());
        return passport;
    }
}