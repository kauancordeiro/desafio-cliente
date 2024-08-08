package dev.cordeiro.desafio_cliente.services;

import dev.cordeiro.desafio_cliente.dtos.ClientDto;
import dev.cordeiro.desafio_cliente.entities.Client;
import dev.cordeiro.desafio_cliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;


    @Transactional(readOnly = true)
    public Page<ClientDto> findAll(PageRequest pageRequest) {

        Page<Client> list = clientRepository.findAll(pageRequest);
        return list.map(ClientDto::new);
    }

    @Transactional(readOnly = true)
    public ClientDto findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if(client.isPresent()){
            ClientDto clientDto = new ClientDto(client.get());
            return clientDto;
        }else{
            return null;
        }


    }

    public Long insert(ClientDto clientDto) {
        Client client = new Client(clientDto);
        client = clientRepository.save(client);

        return client.getId();
    }

    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Transactional
    public ClientDto update(Long id, ClientDto clientDto) {

        Client client = clientRepository.getReferenceById(id);

        client.setCpf(clientDto.getCpf());
        client.setName(clientDto.getName());
        client.setIncome(clientDto.getIncome());
        client.setChildren(clientDto.getChildren());
        client.setBirthDate(clientDto.getBirthDate());

        client = clientRepository.save(client);

        return new ClientDto(client);

    }
}
