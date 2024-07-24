package com.ecommerce.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.api.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    Optional<Produto> findById(Long id);

}
