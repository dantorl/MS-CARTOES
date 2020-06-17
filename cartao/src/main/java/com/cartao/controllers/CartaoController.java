package com.cartao.controllers;

import com.cartao.models.Cartao;
import com.cartao.services.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    @Autowired
    private CartaoService cartaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cartao cadastrarCartao(@RequestBody @Valid Cartao cartao) {

        return cartaoService.cadastrarCartao(cartao);

    }

    @PatchMapping("/{numero}")
    public Cartao ativarCartao(@PathVariable String numero) {
        Optional<Cartao> cartaoOptional;
        try{
            cartaoOptional = cartaoService.buscarCartaoPorNumero(numero);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }

        Cartao cartao = cartaoOptional.get();

        Cartao cartaoObjeto = cartaoService.ativarCartao(cartao);
        return cartaoObjeto;
    }

    @GetMapping("/{numero}")
    public Cartao buscarCartaoPorNumero(@PathVariable String numero) {
        Optional<Cartao> cartaoOptional;
        try{
            cartaoOptional = cartaoService.buscarCartaoPorNumero(numero);
            return cartaoOptional.get();
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
    }
    @GetMapping("/byid/{id}")
    public Cartao buscarCartaoPorId(@PathVariable Integer id) {
        Optional<Cartao> cartaoOptional;
        try{
            cartaoOptional = cartaoService.buscarCartaoPorId(id);
            return cartaoOptional.get();
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        }
    }
    @GetMapping
    public Iterable<Cartao> buscarTodosCartoes() {
        return cartaoService.buscarTodosCartoes();
    }
}