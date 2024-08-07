package dev.cordeiro.desafio_cliente.controllers;

import dev.cordeiro.desafio_cliente.dtos.ClientDto;
import dev.cordeiro.desafio_cliente.services.ClientService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientDto>> findAllPaged(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize){
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<ClientDto> clientDtos = clientService.findAll(pageRequest);

        return ResponseEntity.ok().body(clientDtos);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id){
        ClientDto clientDto = clientService.findById(id);

        if(clientDto != null){
            return ResponseEntity.ok().body(clientDto);

        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<Long> insert(@RequestBody ClientDto clientDto){
        Long clientId;
        clientId = clientService.insert(clientDto);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(clientId)
                .toUri();

        return ResponseEntity.created(uri).body(clientId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        clientService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> update(@RequestBody ClientDto clientDto, @PathVariable Long id){
        clientDto = clientService.update(id, clientDto);

        return ResponseEntity.ok().body(clientDto);
    }




}
