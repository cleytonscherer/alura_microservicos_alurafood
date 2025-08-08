package br.com.alurafood.pedidos.dto;

import br.com.alurafood.pedidos.model.StatusPedido;

public class StatusDto {

    private StatusPedido status;

    public StatusDto() {
    }

    public StatusDto(StatusPedido status) {
        this.status = status;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StatusDto" +
                "\n{" +
                "\n\tstatus=" + status +
                "\n}";
    }
}
