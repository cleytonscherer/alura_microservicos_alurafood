package br.com.alurafood.pedidos.dto;

import br.com.alurafood.pedidos.model.ItemDoPedido;

public class ItemDoPedidoDto {

    private Long id;
    private Integer quantidade;
    private String descricao;

    public ItemDoPedidoDto() {
    }

    public ItemDoPedidoDto(Long id, Integer quantidade, String descricao) {
        this.id = id;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public ItemDoPedidoDto(ItemDoPedido item) {
        this.id = item.getId();
        this.quantidade = item.getQuantidade();
        this.descricao = item.getDescricao();
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

    @Override
    public String toString() {
        return "ItemDoPedidoDto" +
                "\n{" +
                "\n\tid=" + id +
                ",\n\tquantidade=" + quantidade +
                ",\n\tdescricao='" + descricao + '\'' +
                "\n}";
    }
}
