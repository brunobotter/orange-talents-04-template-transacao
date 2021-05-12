package br.com.bruno.orangetransacao.transacao;

import br.com.bruno.orangetransacao.cartao.CartaoResponse;
import br.com.bruno.orangetransacao.estabelecimento.EstabelecimentoResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private String id;
    private BigDecimal valor;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;
    private EstabelecimentoResponse estabelecimento;


    @Deprecated
    public TransacaoResponse() {
    }



    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public CartaoResponse getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public Transacao toModel(){
        return new Transacao(id, valor, cartao.ToModel(), estabelecimento.toModel(), efetivadaEm);
    }
}
