package dev.cordeiro.desafio_cliente.entities;

import dev.cordeiro.desafio_cliente.dtos.ClientDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    @Column(columnDefinition ="TIMESTAMP WITHOUT TIME ZONE",
            name = "birth_date")
    private Instant birthDate;
    private Integer children;


    public Client (ClientDto client){
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.birthDate = client.getBirthDate();
        this.children = client.getChildren();

    }

}
