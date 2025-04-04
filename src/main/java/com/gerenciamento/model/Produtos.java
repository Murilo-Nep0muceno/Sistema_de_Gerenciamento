package com.gerenciamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

@Entity
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, message = "Tamanho Minimo 3")
    private String nome;

    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero.")
    private float preco;

    @Size(min = 3, message = "Tamanho Minimo 3")
    private String descricao;

    public Produtos() {
    }

    public Produtos(String nome, float preco, String desc) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDesc(String descricao) {
        this.descricao = descricao;
    }
}
