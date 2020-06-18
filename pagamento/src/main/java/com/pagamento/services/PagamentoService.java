package com.pagamento.services;

import com.pagamento.client.CartaoClient;
import com.pagamento.exceptions.CartaoNotFoundException;
import com.pagamento.models.Pagamento;
import com.pagamento.repositories.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private CartaoClient cartaoClient;

    public Pagamento cadastrarPagamento(Pagamento pagamento) {
        //*try{cartaoClient.getById(pagamento.getCartaoId());} catch (Exception e){throw new CartaoNotFoundException();}
        cartaoClient.getById(pagamento.getCartaoId());
        Pagamento pagamentoObjeto = pagamentoRepository.save(pagamento);
        return pagamentoObjeto;
    }

    public List<Pagamento> buscarPagamentos(Integer id) {
        //*try{cartaoClient.getById(id);} catch (Exception e){throw new CartaoNotFoundException();}
        cartaoClient.getById(id);

        List<Pagamento> pagamentos = pagamentoRepository.findByCartaoId(id);
        return pagamentos;
    }
}
