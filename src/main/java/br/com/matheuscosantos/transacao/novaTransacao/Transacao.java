package br.com.matheuscosantos.transacao.novaTransacao;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String idTransacao;
    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String id,
                     BigDecimal valor,
                     Estabelecimento estabelecimento,
                     Cartao cartao,
                     LocalDateTime efetivadaEm) {
        this.idTransacao = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Long getId() {
        return id;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
