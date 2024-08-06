package dev.cordeiro.desafio_cliente.dtos;

import dev.cordeiro.desafio_cliente.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDto {

    private String name;
    private String cpf;
    private Double income;
    private Instant birthDate;
    private Integer children;


    public ClientDto (Client client){
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.birthDate = client.getBirthDate();
        this.children = client.getChildren();

    }

}
