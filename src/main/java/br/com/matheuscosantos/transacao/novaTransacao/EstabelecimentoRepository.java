package br.com.matheuscosantos.transacao.novaTransacao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {
    List<Estabelecimento> findByNomeAndCidadeAndEndereco(String nome, String cidade, String endereco);
}
