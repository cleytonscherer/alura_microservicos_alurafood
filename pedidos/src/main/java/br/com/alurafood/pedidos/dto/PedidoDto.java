package br.com.alurafood.pedidos.dto;

import br.com.alurafood.pedidos.model.ItemDoPedido;
import br.com.alurafood.pedidos.model.Pedido;
import br.com.alurafood.pedidos.model.StatusPedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class PedidoDto {

    private Long id;
    private LocalDateTime dataHora;
    private StatusPedido status;
    private List<ItemDoPedidoDto> itens = new ArrayList<>();

    public PedidoDto() {
    }

    public PedidoDto(Long id, LocalDateTime dataHora, StatusPedido status, List<ItemDoPedidoDto> itens) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
        this.itens = itens;
    }

    public PedidoDto(Pedido pedido) {
        this.id = pedido.getId();
        this.dataHora = pedido.getDataHora();
        this.status = pedido.getStatus();
        this.itens = pedido.getItensDto();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<ItemDoPedidoDto> getItensDto() {
        return itens;
    }

    public List<ItemDoPedido> getItens() {
        return itens.stream().map(i -> new ItemDoPedido(i)).toList();
    }

    public void setItensDto(List<ItemDoPedidoDto> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "PedidoDto" +
                "\n{" +
                "\n\tid=" + id +
                ",\n\tdataHora=" + dataHora +
                ",\n\tstatus=" + status +
                ",\n\titens=" + itens +
                "\n}";
    }


}
