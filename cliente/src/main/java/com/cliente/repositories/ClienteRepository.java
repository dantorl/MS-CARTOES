package com.cliente.repositories;

import com.cliente.models.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository  extends CrudRepository<Cliente, Integer> {
}
