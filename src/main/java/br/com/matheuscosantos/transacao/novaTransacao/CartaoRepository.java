package br.com.matheuscosantos.transacao.novaTransacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    List<Cartao> findByIdCartao(String id);
}
