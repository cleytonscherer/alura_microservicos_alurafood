package br.com.alurafood.pedidos.amqp;

import br.com.alurafood.pedidos.dto.PagamentoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

//    @RabbitListener(queues = "pagamento.concluido")
    @RabbitListener(queues = "pagamentos.detalhes-pedido")
    public void recebeMensagem(PagamentoDto pagamento) {
        String mensagem = """
                Dados do pagamento: %s
                Número do Pedido: %s
                Nome: %s
                Valor R$ %s
                Status: %s
                """.formatted(
                        pagamento.id(),
                        pagamento.pedidoId(),
                        pagamento.nome(),
                        pagamento.valor(),
                        pagamento.status()
                );
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Recebi a mensagem:\n " + mensagem);
    }
}
