package com.klimkin.msdeal.service.impl;

import com.klimkin.msdeal.dto.LoanApplicationRequestDTO;
import com.klimkin.msdeal.entity.Client;
import com.klimkin.msdeal.entity.Passport;
import com.klimkin.msdeal.mapper.ClientMapper;
import com.klimkin.msdeal.mapper.EmploymentMapper;
import com.klimkin.msdeal.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplTest {
    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @Mock
    private EmploymentMapper employmentMapper;

    @Test
    void createClient() {
        Client mockClient = new Client();
        when(clientMapper.toClient(new LoanApplicationRequestDTO())).thenReturn(new Client());
        Passport mockPassport = new Passport();
        mockClient.setPassport(mockPassport);
        when(clientRepository.save(mockClient)).thenReturn(mockClient);
        LoanApplicationRequestDTO request = new LoanApplicationRequestDTO();
        Client client = clientMapper.toClient(request);
        Passport passport = new Passport();
        passport.setSeries(request.getPassportSeries());
        passport.setNumber(request.getPassportNumber());
        client.setPassport(passport);

        assertEquals(clientRepository.save(client), mockClient);
        assertEquals(clientService.createClient(request), mockClient);
        assertEquals(clientMapper.toClient(request), client);
    }

    @Test
    void findClient() {
        Long clientId = 6L;
        Optional<Client> client = Optional.of(new Client());
        when(clientRepository.findById(clientId)).thenReturn(client);
        assertEquals(clientRepository.findById(clientId), client);

        assertEquals(clientService.findClient(clientId), new Client());
    }

    @Test
    void updateEmployment() {
    }

    @Test
    void enrichPassport() {
    }
}