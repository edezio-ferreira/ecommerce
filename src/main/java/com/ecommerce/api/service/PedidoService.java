package com.ecommerce.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.api.model.Pedido;
import com.ecommerce.api.model.Produto;
import com.ecommerce.api.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido adicionarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> obterPedido(Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        Double somaValor = 0.0;

        if (pedido.isPresent()) {
            for(Produto produto : pedido.get().getProdutos()) {
                somaValor += produto.getPreco();
            }
            if (somaValor>200.0) {
                pedido.get().setValorTotal(somaValor-(somaValor*0.1));
            } else {
                pedido.get().setValorTotal(somaValor);
            }
            return pedido;
        } else {
            return null;
        }
    }

}
