package br.com.matheuscosantos.transacao.novaTransacao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String idCartao;
    private String email;

    @OneToMany(mappedBy = "cartao", cascade = {CascadeType.PERSIST})
    private List<Transacao> transacoes = new ArrayList<>();

    @Deprecated
    public Cartao() {
    }

    public Cartao(String idCartao,
                  String email) {
        this.idCartao = idCartao;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getIdCartao() {
        return idCartao;
    }

    public String getEmail() {
        return email;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
}
