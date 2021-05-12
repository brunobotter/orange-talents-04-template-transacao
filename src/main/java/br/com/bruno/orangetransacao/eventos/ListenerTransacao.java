package br.com.bruno.orangetransacao.eventos;

import br.com.bruno.orangetransacao.transacao.TransacaoRepository;
import br.com.bruno.orangetransacao.transacao.TransacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerTransacao {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoResponse eventoDeTransacao) {

        System.out.println("#########################");
        System.out.println("Nova Trasação");
        transacaoRepository.save(eventoDeTransacao.toModel());
        System.out.println(eventoDeTransacao.getId());
        System.out.println(eventoDeTransacao.getEfetivadaEm());
        System.out.println(eventoDeTransacao.getCartao().getId());
        System.out.println(eventoDeTransacao.getCartao().getEmail());
        System.out.println(eventoDeTransacao.getEstabelecimento().getCidade());
        System.out.println(eventoDeTransacao.getEstabelecimento().getEndereco());
        System.out.println(eventoDeTransacao.getEstabelecimento().getNome());
        System.out.println(eventoDeTransacao.getValor());
        System.out.println("#########################");
    }
}
