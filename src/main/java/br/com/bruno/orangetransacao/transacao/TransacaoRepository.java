package br.com.bruno.orangetransacao.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends PagingAndSortingRepository<Transacao, String> {


    Page<Transacao> findByCartaoId(String numeroCartao, Pageable pageable);
}
