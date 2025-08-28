package br.com.alurafood.pedidos.dto;

import br.com.alurafood.pedidos.model.ItemDoPedido;
import br.com.alurafood.pedidos.model.Pedido;

public class ItemDoPedidoDto {

    private Long    id;
    private Integer quantidade;
    private String  descricao;
    private Long    pedidoId;

    public ItemDoPedidoDto() {
    }

    public ItemDoPedidoDto(Long id, Integer quantidade, String descricao, Long pedidoId) {
        this.id = id;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.pedidoId = pedidoId;
    }

    public ItemDoPedidoDto(ItemDoPedido item) {
        this.id = item.getId();
        this.quantidade = item.getQuantidade();
        this.descricao = item.getDescricao();
        this.pedidoId = item.getPedido().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getPedido_id() {
        return pedidoId;
    }

    public void setPedido_id(Long pedido_id) {
        this.pedidoId = pedido_id;
    }

    @Override
    public String toString() {
        return "ItemDoPedidoDto" +
                "\n{" +
                "\n\tid=" + id +
                ",\n\tquantidade=" + quantidade +
                ",\n\tdescricao='" + descricao + '\'' +
                ",\n\tpedidoId=" + pedidoId +
                "\n}";
    }
}
