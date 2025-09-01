package br.com.alurafood.pedidos.dto;

import br.com.alurafood.pedidos.model.ItemDoPedido;
import br.com.alurafood.pedidos.model.StatusPagamento;

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
        Long    formaDePagamentoId,
        List<ItemDoPedido> itens
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
