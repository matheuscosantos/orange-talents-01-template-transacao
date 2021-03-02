package br.com.matheuscosantos.transacao.novaTransacao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;
    private String cidade;
    private String endereco;

    @OneToMany(mappedBy = "estabelecimento", cascade = {CascadeType.PERSIST})
    private List<Transacao> transacoes = new ArrayList<>();

    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(String nome,
                           String cidade,
                           String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
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

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
