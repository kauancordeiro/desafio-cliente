package dev.cordeiro.desafio_cliente.repositories;

import dev.cordeiro.desafio_cliente.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
