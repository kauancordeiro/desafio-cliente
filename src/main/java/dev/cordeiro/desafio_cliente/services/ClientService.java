package dev.cordeiro.desafio_cliente.services;

import dev.cordeiro.desafio_cliente.dtos.ClientDto;
import dev.cordeiro.desafio_cliente.entities.Client;
import dev.cordeiro.desafio_cliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    public Page<ClientDto> findAll(PageRequest pageRequest) {

        Page<Client> list = clientRepository.findAll(pageRequest);
        return list.map(ClientDto::new);
    }
}
