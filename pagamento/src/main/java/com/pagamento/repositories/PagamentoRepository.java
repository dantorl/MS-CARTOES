package com.pagamento.repositories;

import com.pagamento.models.Pagamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> {
    List<Pagamento> findByCartaoId(Integer cartaoId);
}
