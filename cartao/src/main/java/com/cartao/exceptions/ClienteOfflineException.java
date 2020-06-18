package com.cartao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Serviço de Cliente Fora do Ar - Volte Mais Tarde")
public class ClienteOfflineException extends RuntimeException {
}
