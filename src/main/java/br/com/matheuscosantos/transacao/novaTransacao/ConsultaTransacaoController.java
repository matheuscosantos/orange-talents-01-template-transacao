package br.com.matheuscosantos.transacao.novaTransacao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cartoes")
public class ConsultaTransacaoController {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping("/{id}/trasacoes")
    public ResponseEntity<?> consulta(@PathVariable Long id) {
        Optional<Cartao> cartao = cartaoRepository.findById(id);
        if (cartao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cartão informado não encontrado");
        }

        List<Transacao> transacoes = transacaoRepository.findAllByCartaoId(id);
        if (transacoes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ainda não existe transação para o cartão informado");
        }

        List<TransacaoResponse> trasacoesResponse = new ArrayList<TransacaoResponse>();
        transacoes.stream().forEach(t -> {
            TransacaoResponse transacaoResponse = new TransacaoResponse(t);
            trasacoesResponse.add(transacaoResponse);
        });

        return ResponseEntity.ok().body(trasacoesResponse);
    }
}