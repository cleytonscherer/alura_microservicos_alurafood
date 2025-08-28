package br.com.alurafood.pagamentos.service;

import br.com.alurafood.pagamentos.dto.PagamentoDto;
import br.com.alurafood.pagamentos.http.PedidoClient;
import br.com.alurafood.pagamentos.model.Pagamento;
import br.com.alurafood.pagamentos.model.StatusPagamento;
import br.com.alurafood.pagamentos.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository repository;

    @Autowired
    private PedidoClient pedido;

//    @Autowired
//    private ModelMapper modelMapper;

    public Page<PagamentoDto> obterTodos(Pageable paginacao) {
//        return repository.findAll(paginacao).map(p -> modelMapper.map(p, PagamentoDto.class));
        return repository.findAll(paginacao).map(PagamentoDto::new);
//        return repository.findAll(paginacao).stream().map(PagamentoDto::new).collect(Collectors.toUnmodifiableList());
    }

    public PagamentoDto obterPorId(Long id) {
        Pagamento pagamento = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
//        return modelMapper.map(pagamento, PagamentoDto.class);
        pagamento.setItens(pedido.obterItensDoPedido(pagamento.getPedidoId()).getItens());
        return new PagamentoDto(pagamento);
    }

    public PagamentoDto criarPagamento(PagamentoDto dto) {

        System.out.println("criarPagamento(" + dto + ")");

        Pagamento pagamento = new Pagamento(dto);
        pagamento.setStatus(StatusPagamento.CRIADO);
        repository.save(pagamento);

        System.out.println(pagamento);

        return new PagamentoDto(pagamento);
    }

    public PagamentoDto atualizarPagamento(Long id, PagamentoDto dto) {
        Pagamento pagamento = new Pagamento(dto);
        pagamento.setId(id);
        pagamento = repository.save(pagamento);
        return new PagamentoDto(pagamento);
    }

    public void excluirPagamento(Long id) {
        repository.deleteById(id);
    }

    public void confirmarPagamento(Long id) {
        Optional<Pagamento> pagamento = repository.findById(id);

        if (pagamento.isEmpty()) {
            throw new EntityNotFoundException();
        }

        pagamento.get().setStatus(StatusPagamento.CONFIRMADO);
        repository.save(pagamento.get());
        pedido.atualizaPagamento(pagamento.get().getPedidoId());
    }

    public void alteraStatus(Long id) {

        Optional<Pagamento> pagamento = repository.findById(id);

        if (pagamento.isEmpty()) {
            throw new EntityNotFoundException();
        }

        pagamento.get().setStatus(StatusPagamento.CONFIRMADO_SEM_INTEGRACAO);
        repository.save(pagamento.get());
    }
}
