package com.gerenciamento.controller;

import com.gerenciamento.model.Produtos;
import com.gerenciamento.model.Usuarios;
import com.gerenciamento.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/produtos")
@RestController
@Slf4j
public class productController {

    @Autowired
    private ProductRepository pr;


    @GetMapping("/api")
    public List<Produtos> listALLApi(){
        var produtos = pr.findAll();
        
        return produtos;
    }

    @GetMapping("/api/{id}")
    public Optional<Produtos> getUserById(@PathVariable Long id){
        var au = pr.findById(id);
        return au;

    }

    @DeleteMapping("/api/{id}")
    public List<Produtos> deleteUserApi(@PathVariable Long id){

        if (pr.existsById(id)){
            pr.deleteById(id);
        }
        return pr.findAll();
    }

    @PostMapping("/api")
    public ResponseEntity<?> addUsers(@RequestBody @Valid Produtos produtos, BindingResult result) {
        if (result.hasErrors()) {
            List<String> erros = result.getFieldErrors().stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest().body(erros);
        }

        Produtos salvo = pr.save(produtos);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/api/{id}")
    public ResponseEntity<Produtos> updateUserApi(@PathVariable Long id, @RequestBody Produtos produtosAtualizado) {
        return pr.findById(id).map(produtos -> {
            produtos.setNome(produtosAtualizado.getNome());
            produtos.setPreco(produtosAtualizado.getPreco());
            produtos.setDesc(produtosAtualizado.getDescricao());

            Produtos atualizado = pr.save(produtos);
            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }
    




}
