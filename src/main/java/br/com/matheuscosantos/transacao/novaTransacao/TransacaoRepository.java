package br.com.matheuscosantos.transacao.novaTransacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    @Query(value = "SELECT * FROM transacao t WHERE t.cartao_id = :id ORDER BY efetivada_em LIMIT 10", nativeQuery = true)
    List<Transacao> findAllByCartaoId(Long id);
}
