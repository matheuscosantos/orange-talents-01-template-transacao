package br.com.matheuscosantos.transacao.novaTransacao;

import java.util.List;

public class EventoEstabelecimento {

    private String nome;
    private String cidade;
    private String endereco;

    public EventoEstabelecimento() {

    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toModel(EstabelecimentoRepository estabelecimentoRepository) {
        List<Estabelecimento> estabelecimento = estabelecimentoRepository.findByNomeAndCidadeAndEndereco(nome, cidade, endereco);
        if(estabelecimento.isEmpty()) {
            return new Estabelecimento(nome, cidade, endereco);
        }
        return estabelecimento.get(0);
    }

}