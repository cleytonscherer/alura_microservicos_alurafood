package br.com.alurafood.pagamentos.dto;

import br.com.alurafood.pagamentos.model.ItemDoPedido;
import br.com.alurafood.pagamentos.model.Pagamento;
import br.com.alurafood.pagamentos.model.StatusPagamento;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.List;

public record PagamentoDto(
        Long    id,

        @NotNull
        @Positive
        BigDecimal valor,

//        @NotBlank
        @Size(max = 100)
        String  nome,

//        @NotBlank
        @Size(max = 19)
        String  numeroCartao,

//        @NotBlank
        @Size(max = 7)
        String  expiracaoCartao,

//        @NotBlank
        @Size(min = 3, max = 3)
        String  codigoVerificador,

        @NotNull
        @Enumerated(EnumType.STRING)
        StatusPagamento status,

        @NotNull
        Long    pedidoId,

        @NotNull
        Long    formaDePagamentoId,

        List<ItemDoPedido> itens
) {

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
}
