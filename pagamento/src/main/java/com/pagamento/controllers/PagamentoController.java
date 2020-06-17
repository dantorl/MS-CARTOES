package com.pagamento.controllers;

import com.pagamento.models.Pagamento;
import com.pagamento.models.dto.PagamentoRequestDTO;
import com.pagamento.models.dto.PagamentoResponseDTO;
import com.pagamento.models.mappers.PagamentoMapper;
import com.pagamento.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/pagamento")
    public PagamentoResponseDTO cadastrarCartao(@RequestBody PagamentoRequestDTO pagamentoRequest) {
        Pagamento pagamento = PagamentoMapper.toPagamento(pagamentoRequest);

        //pagamento.setCartao(cartaoOptional.get());
        Pagamento pagamentoObjeto = pagamentoService.cadastrarPagamento(pagamento);
        return PagamentoMapper.toPagamentoResponse(pagamentoObjeto);
    }

    @GetMapping("/pagamentos/{id}")
    public List<PagamentoResponseDTO> buscarPagamentos(@PathVariable Integer id) {

        List<Pagamento> pagamentos = pagamentoService.buscarPagamentos(id);
        return PagamentoMapper.toPagamentoResponse(pagamentos);
    }
}
