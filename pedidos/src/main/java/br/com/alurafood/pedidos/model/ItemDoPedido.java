package br.com.alurafood.pedidos.model;

import br.com.alurafood.pedidos.dto.ItemDoPedidoDto;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@Entity
@Table(name = "item_do_pedido")
public class ItemDoPedido {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private Integer quantidade;

    private String descricao;

    @ManyToOne(optional=false)
    private Pedido pedido;

    public ItemDoPedido() {
    }

    public ItemDoPedido(Long id, @NotNull Integer quantidade, String descricao, Pedido pedido) {
        this.id = id;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.pedido = pedido;
    }

    public ItemDoPedido(ItemDoPedidoDto itemDto) {
        this.id = itemDto.getId();
        this.quantidade = itemDto.getQuantidade();
        this.descricao = itemDto.getDescricao();
//        this.pedido = itemDto.;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public String toString() {
        return "ItemDoPedido" +
                "\n{" +
                "\n\tid=" + id +
                ",\n\tquantidade=" + quantidade +
                ",\n\tdescricao='" + descricao + '\'' +
                ",\n\tpedido=" + pedido +
                "\n}";
    }
}
