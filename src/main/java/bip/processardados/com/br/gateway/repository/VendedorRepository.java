package bip.processardados.com.br.gateway.repository;

import org.springframework.data.repository.CrudRepository;

import bip.processardados.com.br.domain.Vendedor;

import java.util.UUID;

public interface VendedorRepository extends CrudRepository<Vendedor, UUID> {
    Vendedor getByCpf(String cpf);
}
