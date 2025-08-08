package br.com.alurafood.pedidos.model;

import br.com.alurafood.pedidos.dto.ItemDoPedidoDto;
import br.com.alurafood.pedidos.dto.PedidoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDateTime dataHora;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="pedido")
    private List<ItemDoPedido> itens = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Long id, LocalDateTime dataHora, StatusPedido status, List<ItemDoPedido> itens) {
        this.id = id;
        this.dataHora = dataHora;
        this.status = status;
        this.itens = itens;
    }

    public Pedido(PedidoDto dto) {
        this.id = dto.getId();
        this.dataHora = dto.getDataHora();
        this.status = dto.getStatus();
        this.itens = dto.getItens();
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

    public List<ItemDoPedido> getItens() {
        return itens;
    }

    public List<ItemDoPedidoDto> getItensDto() {
        return itens.stream().map(ItemDoPedidoDto::new).toList();
    }

    public void setItens(List<ItemDoPedido> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Pedido" +
                "\n{" +
                "\n\tid=" + id +
                ",\n\tdataHora=" + dataHora +
                ",\n\tstatus=" + status +
                ",\n\titens=" + itens +
                "\n}";
    }
}
