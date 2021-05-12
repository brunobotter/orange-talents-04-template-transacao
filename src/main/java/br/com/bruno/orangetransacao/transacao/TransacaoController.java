package br.com.bruno.orangetransacao.transacao;

import br.com.bruno.orangetransacao.cartao.CartaoRequest;
import br.com.bruno.orangetransacao.feign.CartaoTransacao;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("transacao")
public class TransacaoController {

    @Autowired
    private CartaoTransacao cartaoTransacao;

    public TransacaoController(CartaoTransacao cartaoTransacao) {
        this.cartaoTransacao = cartaoTransacao;
    }

    @PostMapping
    public ResponseEntity<?> enviar(@RequestBody @Valid CartaoRequest request){
    try{
        cartaoTransacao.iniciarTransacao(request);
        return ResponseEntity.ok("Transação iniciada");
    }catch (FeignException.FeignServerException | FeignException.FeignClientException e){
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> parar(@PathVariable("id") String id){
        try{
            cartaoTransacao.pararTransacao(id);
            return ResponseEntity.ok("Transação Finalizada");
        }catch (FeignException.FeignServerException | FeignException.FeignClientException e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
