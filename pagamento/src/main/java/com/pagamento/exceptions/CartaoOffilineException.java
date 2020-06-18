package com.pagamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Serviço de Cartões Indisponível no momento")
public class CartaoOffilineException extends RuntimeException{
}
