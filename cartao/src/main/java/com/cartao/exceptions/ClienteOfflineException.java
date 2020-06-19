package com.cartao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Serviço de Cliente Fora do Ar - Volte Mais Tarde")
public class ClienteOfflineException extends RuntimeException {
}
