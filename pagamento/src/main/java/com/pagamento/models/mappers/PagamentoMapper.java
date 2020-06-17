package com.pagamento.models.mappers;

import com.pagamento.models.Pagamento;
import com.pagamento.models.dto.PagamentoRequestDTO;
import com.pagamento.models.dto.PagamentoResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class PagamentoMapper {
    public static PagamentoResponseDTO toPagamentoResponse(Pagamento pagamento) {
        PagamentoResponseDTO pagamentoResponse = new PagamentoResponseDTO();

        pagamentoResponse.setId(pagamento.getIdPagamento());
        pagamentoResponse.setIdCartao(pagamento.getCartaoId());
        pagamentoResponse.setDescricao(pagamento.getDescricao());
        pagamentoResponse.setValor(pagamento.getValor());

        return pagamentoResponse;
    }

    public static List<PagamentoResponseDTO> toPagamentoResponse(List<Pagamento> pagamentos) {
        List<PagamentoResponseDTO> pagamentoResponses = new ArrayList<>();

        for (Pagamento pagamento : pagamentos) {
            pagamentoResponses.add(toPagamentoResponse(pagamento));
        }

        return pagamentoResponses;
    }

    public static Pagamento toPagamento(PagamentoRequestDTO createPagamentoRequest) {

        Pagamento pagamento = new Pagamento();

        pagamento.setDescricao(createPagamentoRequest.getDescricao());
        pagamento.setValor(createPagamentoRequest.getValor());
        pagamento.setCartaoId(createPagamentoRequest.getIdCartao());

        return pagamento;
    }
}
