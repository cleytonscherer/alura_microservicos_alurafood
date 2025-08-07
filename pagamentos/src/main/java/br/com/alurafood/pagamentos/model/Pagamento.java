package br.com.alurafood.pagamentos.model;

import br.com.alurafood.pagamentos.dto.PagamentoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

@Entity
@Table(name = "pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;

    @NotNull
    @Positive
    private BigDecimal  valor;

//    @NotBlank
    @Size(max = 100)
    private String  nome;

//    @NotBlank
    @Size(max = 19)
    @Column(name = "numero")
    private String  numeroCartao;

//    @NotBlank
    @Size(max = 7)
    @Column(name = "expiracao")
    private String  expiracaoCartao;

//    @NotBlank
    @Size(min = 3, max = 3)
    @Column(name = "codigo")
    private String  codigoVerificador;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusPagamento status;

    @NotNull
    private Long    pedidoId;

    @NotNull
    private Long    formaDePagamentoId;


    public Pagamento() {
    }

    public Pagamento(
            Long id, BigDecimal valor,
            String nome,
            String numeroCartao,
            String expiracaoCartao,
            String codigoVerificador,
            StatusPagamento status,
            Long pedidoId,
            Long formaDePagamentoId
    ) {
        this.id = id;
        this.valor = valor;
        this.nome = nome;
        this.numeroCartao = numeroCartao;
        this.expiracaoCartao = expiracaoCartao;
        this.codigoVerificador = codigoVerificador;
        this.status = status;
        this.pedidoId = pedidoId;
        this.formaDePagamentoId = formaDePagamentoId;
    }

    public Pagamento(PagamentoDto dto) {
        this.id = dto.id();
        this.valor = dto.valor();
        this.nome = dto.nome();
        this.numeroCartao = dto.numeroCartao();
        this.expiracaoCartao = dto.expiracaoCartao();
        this.codigoVerificador = dto.codigoVerificador();
        this.status = dto.status();
        this.pedidoId = dto.pedidoId();
        this.formaDePagamentoId = dto.formaDePagamentoId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getExpiracaoCartao() {
        return expiracaoCartao;
    }

    public void setExpiracaoCartao(String expiracaoCartao) {
        this.expiracaoCartao = expiracaoCartao;
    }

    public String getCodigoVerificador() {
        return codigoVerificador;
    }

    public void setCodigoVerificador(String codigoVerificador) {
        this.codigoVerificador = codigoVerificador;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getFormaDePagamentoId() {
        return formaDePagamentoId;
    }

    public void setFormaDePagamentoId(Long formaDePagamentoId) {
        this.formaDePagamentoId = formaDePagamentoId;
    }

    @Override
    public String toString() {
        return "Pagamento" +
                "\n{" +
                "\n\tid=" + id +
                ",\n\tvalor=" + valor +
                ",\n\tnome='" + nome + '\'' +
                ",\n\tnumeroCartao='" + numeroCartao + '\'' +
                ",\n\texpiracaoCartao='" + expiracaoCartao + '\'' +
                ",\n\tcodigoVerificador='" + codigoVerificador + '\'' +
                ",\n\tstatus=" + status +
                ",\n\tpedidoId=" + pedidoId +
                ",\n\tformaDePagamentoId=" + formaDePagamentoId +
                "\n}";
    }
}
