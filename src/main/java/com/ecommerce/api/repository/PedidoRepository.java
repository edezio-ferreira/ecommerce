package com.ecommerce.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.api.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {

    Optional<Pedido> findById(Long id);

}
