package com.gerenciamento.repository;

import com.gerenciamento.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository  extends JpaRepository<Usuarios, Long> {
    Usuarios findByEmail(String id);
}
