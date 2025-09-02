package br.com.alurafood.avaliacao.dto;


import java.math.BigDecimal;
import java.util.List;

public record PagamentoDto(
        Long    id,
        BigDecimal valor,
        String  nome,
        String  numeroCartao,
        String  expiracaoCartao,
        String  codigoVerificador,
        StatusPagamento status,
        Long    pedidoId,
        Long    formaDePagamentoId

//        List<ItemDoPedido> itens
) {
        /*
        public PagamentoDto(Pagamento pagamento) {
                this(   pagamento.getId(),
                        pagamento.getValor(),
                        pagamento.getNome(),
                        pagamento.getNumeroCartao(),
                        pagamento.getExpiracaoCartao(),
                        pagamento.getCodigoVerificador(),
                        pagamento.getStatus(),
                        pagamento.getPedidoId(),
                        pagamento.getFormaDePagamentoId(),
                        pagamento.getItens()
                );
        }
         */
}
