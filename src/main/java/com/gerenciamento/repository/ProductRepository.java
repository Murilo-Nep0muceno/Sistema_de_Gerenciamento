package com.gerenciamento.repository;

import com.gerenciamento.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Produtos, Long> {
}
