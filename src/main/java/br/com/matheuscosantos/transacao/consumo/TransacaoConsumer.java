package br.com.matheuscosantos.transacao.consumo;

import br.com.matheuscosantos.transacao.novaTransacao.*;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TransacaoConsumer {

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {

        Transacao transacao = eventoDeTransacao.toModel(eventoDeTransacao, cartaoRepository, estabelecimentoRepository);
        transacaoRepository.save(transacao);
    }
}