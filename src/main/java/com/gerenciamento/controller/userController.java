package com.gerenciamento.controller;

import com.gerenciamento.model.Usuarios;
import com.gerenciamento.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/usuarios")
@Slf4j
public class userController {

    @Autowired
    private UserRepository ur;
    @GetMapping
    public ModelAndView formUser(){
        ModelAndView mv = new ModelAndView("usuarioForm");
        Usuarios usuario = new Usuarios();
        List<Usuarios> all = ur.findAll();

        mv.addObject("userList", all);

        return mv;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id){
        if (ur.existsById(id)){
            ur.deleteById(id);
        }
        return "redirect:/usuarios";
    }


    @PutMapping("/{id}")
    public Usuarios updateUser(@PathVariable Long id, @RequestBody Usuarios usuarioAtualizado){
        return ur.findById(id).map(usuario -> {
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setSenha(usuarioAtualizado.getSenha());
            return ur.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
    }
    @PostMapping
    public Usuarios submitForm(@RequestBody Usuarios usuario){

        return ur.save(usuario);

    }


    @GetMapping("/api")
    public List<Usuarios> listALLApi(){
        var usuarios = ur.findAll();
        return usuarios;

    }

    @GetMapping("/api/{id}")
    public Optional<Usuarios> getUserById(@PathVariable Long id){
         var au = ur.findById(id);
        return au;

    }



    @DeleteMapping("/api/{id}")
    public List<Usuarios> deleteUserApi(@PathVariable Long id){

        if (ur.existsById(id)){
            ur.deleteById(id);
        }
        return ur.findAll();
    }

    @PostMapping("/api")
    public ResponseEntity<?> addUsers(@RequestBody @Valid Usuarios usuarios, BindingResult result) {
        if (result.hasErrors()) {
            List<String> erros = result.getFieldErrors().stream()
                    .map(error -> error.getField() + ": " + error.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest().body(erros);
        }

        Usuarios salvo = ur.save(usuarios);
        return ResponseEntity.ok(salvo);
    }

    @PutMapping("/api/{id}")
    public ResponseEntity<Usuarios> updateUserApi(@PathVariable Long id, @RequestBody Usuarios usuarioAtualizado) {
        return ur.findById(id).map(usuario -> {
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setSenha(usuarioAtualizado.getSenha());

            Usuarios atualizado = ur.save(usuario);
            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

}
